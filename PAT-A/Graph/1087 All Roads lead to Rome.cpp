//
// Created by Administrator on 2019/12/25.
//

// begin at 2019/12/30 15:45

/**
6 7 HZH
ROM 100
PKN 40
GDN 55
PRS 95
BLN 80
ROM GDN 1
BLN ROM 1
HZH PKN 1
PRS ROM 2
BLN HZH 2
PKN GDN 1
HZH PRS 1

Sample Output:
3 3 195 97
HZH->PRS->ROM
*/

#include <map>
#include <vector>
#include <iostream>
#include <cmath>
#include <string>
using namespace std;
#define MAXN 210

const int INF = (1<<31)-1;
vector<int> pre[MAXN], path, tempPath;
int n,m, weight[MAXN], d[MAXN], G[MAXN][MAXN];
map<string, int> cityToIndex;
map<int, string> indexToCity;
bool vis[MAXN] = {false};
int numPath=0, maxW = 0;
double maxAvg = 0;

void dijkstra(int s){
	fill(d, d+MAXN, INF);
	d[s] = 0;
	for(int i=0; i<n; i++){
		int u=-1, minD=INF;
		for(int j=0; j<n; j++){
			if(d[j]<minD && !vis[j]){
				minD = d[j];
				u = j;
			}
		}
		if(u==-1) return;
		vis[u] = true;
		for(int v=0; v<n; v++){
			if(G[u][v] != INF && !vis[v]){
				if(G[u][v]+d[u] < d[v]){
					pre[v].clear();
					pre[v].push_back(u);
					d[v] = G[u][v] + d[u];
				}else if(G[u][v] + d[u] == d[v]){
					pre[v].push_back(u);
				}
			}
		}
	}
}

void dfs(int v){
	if(v==0){
		tempPath.push_back(v);
		numPath++;
		int tempW = 0;
		for(int i=tempPath.size()-1; i>=0; i--){
			tempW += weight[tempPath[i]];
		} 
		double tempAvg = 1.0*tempW / (tempPath.size()-1);
		if(tempW > maxW){
			maxW = tempW;
			maxAvg = tempAvg;
			path = tempPath;
		}else if(tempW == maxW && tempAvg > maxAvg){
			maxAvg = tempAvg;
			path = tempPath;
		}
		tempPath.pop_back();
		return;
	}
	tempPath.push_back(v);
	for(int i=0; i<pre[v].size(); i++)
		dfs(pre[v][i]);
	tempPath.pop_back();
}

int main(){
	fill(G[0], G[0]+MAXN*MAXN, INF);
	string city;
	cin >> n >> m >> city;
	cityToIndex[city] = 0;
	indexToCity[0] = city;
	weight[0] = 0;
	for(int i=1; i<n; i++){
		cin >> city >> weight[i];
		cityToIndex[city] = i;
		indexToCity[i] = city;
	}
	for(int u, v, c, i=0; i<m; i++){
		string c1, c2;
		cin >> c1 >> c2 >> c;
		u = cityToIndex[c1];
		v = cityToIndex[c2];
		G[u][v] = G[v][u] = c;
	}
	int rom = cityToIndex["ROM"];
	dijkstra(0);
	dfs(rom);
	cout << numPath << " " << d[rom] << " " << maxW << " " << (int) maxAvg << endl;
	for(int i=path.size()-1; i>=0; i--){
		cout << indexToCity[path[i]];
		if(i)
			cout << "->";
	}
	return 0;
}

// finish at 2019/12/30 16:39