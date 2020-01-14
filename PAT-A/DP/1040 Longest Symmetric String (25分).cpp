//
// Created by Administrator on 2019/12/31.
//

//begin at 14/01/20 21:24

/*
Sample Input:
Is PAT&TAP symmetric?
    
Sample Output:
11
*/

#include <iostream>
#include <cstring>
using namespace std;

const int maxn = 1010;

char str[maxn];
int dp[maxn][maxn];

int main(){
	fgets(str,maxn,stdin);
	memset(dp, 0, sizeof(dp));
	int len = strlen(str), ans = 1;
	
	//border
	for(int i=0; i<len; i++){
		dp[i][i] = 1;
		if(i < len-1){
			if(str[i] == str[i+1]){
				dp[i][i+1] = 1;
				ans = 2;
			}
		}
	}
	
	//state transition equation
	for(int l=3; l<=len; l++){
		// enum the begin of subseq
		for(int i=0; i+l-1 < len; i++){
			int j=i+l-1;
			if(str[i] == str[j] && dp[i+1][j-1] == 1){
				dp[i][j] = 1;
				ans = l;
			}
		}
	}
	cout << ans;
}


//finish at 14/01/20 23:10
