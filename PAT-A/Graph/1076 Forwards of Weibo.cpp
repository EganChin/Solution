//
// Created by Administrator on 2019/8/27.
//

/**
Sample Input:
7 3
3 2 3 4
0
2 5 6
2 3 1
2 3 4
1 4
1 5
2 2 6
Sample Output:
4
5
 */

// begin at 2019/12/25 13:44

#include <cstring>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define MAX_N 1010

struct Node{
	int id;
	int level;
	Node(int i, int l){
		id = i;
		level = l;
	}
};

vector<Node> adj[MAX_N];

int n,l;
bool visit[MAX_N] = {0};

int BFS(int query){
	int amount = 0;
	queue<Node> q;
	Node start(query, 0);
	q.push(start);
	while(!q.empty()){
		Node n = q.front();
		q.pop();
		visit[n.id] = true;
		int u = n.id;
		for(int i=0; i<adj[u].size(); i++){
			Node next = adj[u][i];
			next.level = n.level + 1;
			if(next.level <= l && !visit[next.id]){
				amount++;
				q.push(next);
				visit[next.id] = true;
			}
		}
		
	}
	return amount;
}

int main(){
	cin >> n >> l;
	for(int i=1,m,u; i<=n; i++){
		cin >> m;
		for(int j=0; j<m; j++){
			cin >> u;
			adj[u].push_back(Node(i, 0));
		}
	}
	cin >> n;
	for(int i=0,q; i<n; i++){
		memset(visit, false, sizeof(visit));
		cin >> q;
//		printf("%d\n", BFS(q));
		cout << BFS(q) << endl;
	}
	return 0;
}

// finish at 2019/12/25 14:48