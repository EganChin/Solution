//
// Created by Administrator on 2019/12/25.
//

/**
Sample Input:
5 6 0 2
1 2 1 5 3
0 1 1
0 2 2
0 3 1
1 2 1
2 4 1
3 4 1

Sample Output:
2 4
 */

// begin at 2019/12/26 9:36

#include<iostream>
#include<algorithm>

using namespace std;

#define MAXN 510
#define INF 2147483647

int n, G[MAXN][MAXN];
int d[MAXN]; // the shortest distance between source and other points
int w[MAXN] = {0}; // the maximum amount of rescue teams between source and outher points
int weight[MAXN]; // the amount of resue teams
int num[MAXN] = {0}; // the number of shortest distance
bool vis[MAXN] = {false};

void dijkstra(int s) {
    fill(d, d + n, INF);
    //init
    d[s] = 0;
    w[s] = weight[s];
    num[s] = 1;

    for (int i = 0; i < n; i++) {
        int u = -1, minD = INF;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && d[j] < minD) {
                u = j;
                minD = d[j];
            }
        }
        // it means other points can't connect source
        if (u == -1) return;
        vis[u] = true;
        for (int v = 0; v < n; v++) {
            int curD = G[u][v] + d[u];
            if (!vis[v] && G[u][v] != INF) {
                if (curD < d[v]) {
                    d[v] = curD;
                    w[v] = weight[v] + w[u];
                    num[v] = num[u];
                } else if (curD == d[v]) {
                    num[v] += num[u];
                    if (weight[v] + w[u] > w[v])
                        w[v] = weight[v] + w[u];
                }
            }
        }
    }
}

int main() {
    int m, c1, c2, u, v, l;
    scanf("%d%d%d%d", &n, &m, &c1, &c2);
    for (int i = 0; i < n; i++) {
        scanf("%d", &weight[i]);
    }
    fill(G[0], G[0] + MAXN * MAXN, INF);
    for (int i = 0; i < m; i++) {
        scanf("%d%d%d", &u, &v, &l);
        G[u][v] = G[v][u] = l;
    }
    dijkstra(c1);
    printf("%d %d\n", num[c2], w[c2]);
    return 0;
}

// finish at 2019/12/26 10:53