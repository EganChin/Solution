//
// Created by Administrator on 2019/12/25.
//

/**
Sample Input:
10 3 3 5
6 7 0
0 1 1
0 2 1
0 3 3
1 3 1
2 3 1

Sample Output:
3 0->2->3 0
*/

// begin at 2019/12/26 11:11

#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
#define MAXV 510
const int INF = (1<<31)-1;
int G[MAXV][MAXV], weight[MAXV], n, m, cmax, sp, numPath=0;
int minNeed = INF, minRemain = INF, d[MAXV];
bool vis[MAXV] = {false};
vector<int> pre[MAXV];
vector<int> tempPath, path;

void dijkstra(int s){
	fill(d, d+n+1, INF);
	d[s] = 0;
	for(int i=0; i<n; i++){
		int minD = INF, u=-1;
		for(int j=0; j<n; j++){
			if(d[j] < minD && !vis[j]){
				u = j;
				minD = d[j];
			}
		}
		if(u==-1) return;
		vis[u] = true;
		// notice v~n, because the stations are numbered from 1 to N
		for(int v=1; v<=n; v++){
			if(!vis[v] && G[u][v] != INF){
				if(d[u]+G[u][v] < d[v]){
					d[v] = d[u]+G[u][v];
					pre[v].clear();
					pre[v].push_back(u);
				}else if(d[u]+G[u][v] == d[v]){
					pre[v].push_back(u);
				}
			}
		}
	}
}

void dfs(int v){
    //arrive source
	if(v==0){
	    tempPath.push_back(v);
	    int need = 0, remain = 0;
	    for(int i=tempPath.size() - 1; i>=0; i--){
	        int id = tempPath[i];
	        if(weight[id] > 0){
	            remain += weight[id];
	        } else{
	            //the remain enough fill current node to perfect condition
	            if(remain >= abs(weight[id])){
	                remain -= abs(weight[id]);
	            } else{
	                //PBMC must send
                    need += abs(weight[id]) - remain;
                    remain = 0;
	            }
	        }
	    }

	    if(need < minNeed){
            // send is more less
            path = tempPath;
	        minNeed = need;
	        minRemain = remain;
	    } else if(need == minNeed && remain < minRemain){
            //send is same but tack back more less
            path = tempPath;
            minRemain = remain;
	    }
	    tempPath.pop_back();
        return;
	}

	tempPath.push_back(v);
	for(int i : pre[v]){
	    dfs(i);
	}
	tempPath.pop_back();
}

int main(){
    fill(G[0], G[0]+MAXV*MAXV, INF);
	cin >> cmax >> n >> sp >> m;
	for(int i=1; i<=n; i++){
		cin >> weight[i];
		weight[i] -= cmax/2;
	}
	for(int i=0, u, v, l; i<m; i++){
	    cin >> u >> v >> l;
	    G[u][v] = G[v][u] = l;
	}
	dijkstra(0);
	dfs(sp);
	cout << minNeed << " ";
	for(int i=path.size()-1; i>=0; i--){
	    cout << path[i];
	    if(i) cout << "->";
	}
	cout << " " << minRemain << endl;
	return 0;
}

// finish at 2019/12/26 14:45