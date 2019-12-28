//
// Created by Administrator on 2019/12/25.
//

/**
Sample Input:
4 5 0 3
0 1 1 20
1 3 2 30
0 3 4 10
0 2 2 20
2 3 1 20



Sample Output:
0 2 3 3 40
*/

// begin at 2019/12/28 16:10

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MAXN 510
const int INF = (1<<31)-1; 

int G[MAXN][MAXN], cost[MAXN][MAXN];
int d[MAXN], minCost=INF;
int n,m,st,ed;
vector<int> pre[MAXN], tempPath, path; 
bool vis[MAXN] = {false};

void dijkstra(int s){
	fill(d, d+n, INF);
	d[s] = 0;
	for(int i=0; i<n; i++){
		int u=-1, minD=INF;
		for(int j=0; j<n; j++){
			if(d[j] < minD && !vis[j]){
				u = j;
				minD = d[j];
			}
		}
		if(u==-1)
			return;
		vis[u] = true;
		for(int v=0; v<n; v++){
			if(!vis[v] && G[u][v] != INF){
				if(G[u][v] + d[u] < d[v]){
					d[v] = G[u][v] + d[u];
					pre[v].clear();
					pre[v].push_back(u);
				}else if(G[u][v] + d[u] == d[v]){
					pre[v].push_back(u);
				}
			}
		}
	}
}

void dfs(int v){
	if(v==st){
		int tempCost = 0;
		tempPath.push_back(v);
		for(int i=tempPath.size()-1; i>0; i--){
			int id = tempPath[i],idNext = tempPath[i-1];
			tempCost += cost[id][idNext];
		}
		if(tempCost < minCost){
			minCost =  tempCost;
			path = tempPath;
		}
		tempPath.pop_back();
	}
	tempPath.push_back(v);
	for(int i=0; i<pre[v].size(); i++){
		dfs(pre[v][i]);
	}
	tempPath.pop_back();
}



int main(){
	scanf("%d%d%d%d", &n,&m,&st,&ed);
	int u,v;
	fill(G[0], G[0]+MAXN*MAXN, INF);
	fill(cost[0], cost[0]+MAXN*MAXN, INF);
	for(int i=0; i<m; i++){
		scanf("%d%d", &u,&v);
		scanf("%d%d", &G[u][v], &cost[u][v]);
		G[v][u] = G[u][v];
		cost[v][u] = cost[u][v];
	}
	dijkstra(st);
	dfs(ed);
	for(int i=path.size()-1; i>=0; i--){
	    cout << path[i] << " ";
	}
	printf("%d %d", d[ed], minCost);
	return 0;
} 

// finish at 2019/12/28 17:06










