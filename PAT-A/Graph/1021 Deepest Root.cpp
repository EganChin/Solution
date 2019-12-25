//
// Created by Administrator on 2019/8/27.
//

/**
Sample Input 1:
5
1 2
1 3
1 4
2 5
Sample Output 1:
3
4
5
Sample Input 2:
5
1 3
1 4
2 5
3 4
Sample Output 2:
Error: 2 components
*/

/**
four step to solve the problem
 1. using union-find to judge the graph whether a connected tree.
 2. take a node to travel the tree in order to attain all deepest nodes and put them into a set.
 3. put nodes into a another set if they are the deepest nodes from node in set.
 4. print nodes in two set.
*/


#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX_N 10010

int n, father[MAX_N], blockNum=0, maxH=0;
vector<int>G[MAX_N], root, temp;

void init(){
	for(int i=1; i<=n; i++){
		father[i] = i;
	}
}

int findRoot(int x){
	int a = x;
	while(x!=father[x]){
		x = father[x];
	}
	//compress
	while(a != father[a]){
		int z = father[a];
		a = father[a];
		father[z] = x;
	}
	return x;
}

void Union(int a, int b){
	int rootA = findRoot(a);
	int rootB = findRoot(b);
	if(rootA != rootB){
		father[rootA] = rootB;
	}
}

bool isRoot[MAX_N] = {0};
void calculateBlockNum(){
	for(int i=1; i<=n; i++)
		isRoot[findRoot(i)] = true;
	for(int i=1; i<=n; i++){
		blockNum+=isRoot[i];
	}
}

void dfs(int u, int h, int last){
	//if current height greter than max height, clear set to restart travel
	if(h > maxH){
		temp.clear();
		maxH = h;
		temp.push_back(u);
	}else if(h== maxH){
		//  If such a root is not unique, print them in increasing order of their numbers. 
		temp.push_back(u);
	}
	
	for(int i=0; i<G[u].size(); i++){
		// prevent loop
		if(G[u][i] == last){
			continue;
		}
		dfs(G[u][i], h+1, u);
	}
}

int main(){
	int a, b;
	cin >> n;
	init();
	for(int i=1; i<n; i++){
		cin >> a >> b;
		G[a].push_back(b);
		G[b].push_back(a);
		Union(a, b);
	}
	calculateBlockNum();
	if(blockNum>1){
		cout << "Error: " << blockNum << " components" << endl;
	}else{
		dfs(1, 1, -1);
		//attain set A
		root = temp;
		dfs(root[0], 1, -1);
		//considered temp as set B
		for(int i=0; i<temp.size(); i++)
			root.push_back(temp[i]);
		sort(root.begin(), root.end());
		cout << root[0] << endl;
		for(int i=1; i<root.size(); i++){
			if(root[i] != root[i-1])
				cout << root[i] << endl;
		}
	}
	return 0;
}


 

