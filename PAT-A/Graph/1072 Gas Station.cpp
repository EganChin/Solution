//
// Created by Administrator on 2019/12/25.
//

// begin at 2019/12/30 14:02

/**
Sample Input 1:
4 3 11 5
1 2 2
1 4 2
1 G1 4
1 G2 3
2 3 2
2 G2 1
3 4 2
3 G3 2
4 G1 3
G2 G1 1
G3 G2 2

Sample Output 1:
G1
2.0 3.3

Sample Input 2:
2 1 2 10
1 G1 9
2 G1 20

Sample Output 2:
No Solution
*/

#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

#define MAXV 1020 //n+m+10
const int INF = (1<<31)-1;

int n, m, k, ds, d[MAXV], G[MAXV][MAXV];
bool vis[MAXV] = {false};

void dijkstra(int s){
	memset(vis, false, sizeof(vis));
	fill(d, d+MAXV, INF);
	d[s] = 0;
	for(int i=0; i<n+m; i++){
		int u=-1, minD=INF;
		for(int j=1; j<=n+m; j++){
			if(!vis[j] && d[j] < minD){
				u = j;
				minD = d[j];
			}
		}
		
		if(u==-1) return;
		vis[u] = true;
		for(int v=1; v<=n+m; v++){
			if(!vis[v] && G[u][v] != INF && G[u][v] + d[u] < d[v]){
				d[v] = G[u][v]+d[u];
			}
		}
	}
}

int getID(char str[]){
	int i=0, len = strlen(str), ID=0;
	while(i<len){
		if(str[i] != 'G'){
			ID = (str[i]-'0') + ID * 10;
		}
		i++;
	}
	if(str[0] == 'G')	return n+ID;
	return ID;
}

int main(){
	scanf("%d%d%d%d", &n, &m, &k, &ds);
	fill(G[0], G[0]+MAXV*MAXV, INF);
	char c1[5], c2[5];
	for(int u,v,w,i=0; i<k; i++){
		scanf("%s %s %d",c1,c2,&w);
		u = getID(c1);
		v = getID(c2);
		G[u][v] = G[v][u] = w;
	}
	
	double ansDis = -1; // The largest and shortest distance
	double ansAvg = INF; // Minimum average distance
	int ansID = -1;	// the index number of the best location
	// Enumerate each station
	for(int i=n+1; i<=n+m; i++){
		double minD = INF, avg = 0;
		dijkstra(i);
		// Enumerate each house, calculate the minimum distance and average distance
		for(int j=1; j<=n; j++){
			if(d[j]>ds){
				minD = -1;
				break;
			}
			if(d[j]<minD){
				minD=d[j];
			}
			avg += 1.0*d[j]/n;
		}
		//Some houses are not in service range.
		if(minD == -1) continue;
		if(minD > ansDis){
			//All house are in service range and the distance is further
			ansDis = minD;
			ansID = i;
			ansAvg = avg;
		}else if(minD == ansDis && avg < ansAvg){
			//If there are more than one solution, output the one with the smallest average distance to all the houses
			ansID = i;
			ansAvg = avg;
		}
	}
	if(ansID == -1){
		printf("No Solution");
	}else{
		printf("G%d\n", ansID-n);
		printf("%.1f %.1f\n", ansDis, ansAvg);
	}
	return 0;
}

// finish at 2019/12/30 15:13