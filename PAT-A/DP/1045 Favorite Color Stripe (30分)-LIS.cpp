//
// Created by Administrator on 2019/12/31.
//

// begin at 14/01/20 14:39

/*
Sample Input:
6
5 2 3 1 5 6
12 2 2 4 1 5 5 6 3 1 1 5 6

Sample Output:
7
*/

#include <cstring>
#include <iostream>
#include <algorithm>
using namespace std;

const int maxn = 210;
const int maxl = 100010;

int map[maxn];	// favorite color -> order(0 - n)
int a[maxl];	// the order of favorite color
int dp[maxl];	//length of subsequence

int main(){
	int n, m, l, x, num = 0;
	cin >> n >> m;
	memset(map, -1, sizeof(map));
	for(int i=0; i<m; i++){
		cin >> x;
		map[x] = i;
	}
	cin >> l;
	for(int i=0; i<l; i++){
		cin >> x;
		if(map[x] >= 0){
			a[num++] = map[x];
		}
	}

	int ans = -1;
	for(int i=0; i<num; i++){
		dp[i] = 1;
		for(int j=0; j<i; j++){
			if(a[j] <= a[i] && dp[j] + 1 > dp[i] ){
				dp[i] = dp[j] + 1;
			}
		}
		ans = max(dp[i], ans);
	}

	cout << ans;
	return 0;
}

// finish at 14/01/20 15:04















