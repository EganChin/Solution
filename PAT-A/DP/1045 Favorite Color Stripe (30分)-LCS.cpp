//
// Created by Administrator on 2019/12/31.
//

// begin at 14/01/20 20:52

/*
Sample Input:
6
5 2 3 1 5 6
12 2 2 4 1 5 5 6 3 1 1 5 6

Sample Output:
7
*/

#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

const int maxn = 210;
const int maxl = 100010;

int a[maxn], b[maxl], dp[maxn][maxl] = {0};

int main(){
	int n, m, l;
	cin >> n >> m;
	for(int i=1; i<=m; i++){
		cin >> a[i];
		dp[i][0] = 0;
	}
	cin >> l;
	for(int i=1; i<=l; i++){
		cin >> b[i];
		dp[0][i] = 0;
	}
	
	for(int i=1; i<=m; i++){
		for(int j=1; j<=l; j++){
			int MAX = max(dp[i-1][j], dp[i][j-1]);
			if(a[i] == b[j]){
				dp[i][j] = MAX+1;
			}else{
				dp[i][j] = MAX;
			}
		}
	}
	
	cout << dp[m][l];
}











