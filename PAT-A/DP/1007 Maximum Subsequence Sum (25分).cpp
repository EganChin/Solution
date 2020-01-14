//
// Created by Administrator on 2019/12/31.
//

// begin at /14/01/20 13:58

/**

Sample Input:
10
-10 1 2 3 4 -5 -23 3 7 -21
    
Sample Output:
10 1 4

**/

#include <iostream>
using namespace std;

const int maxn = 100010;

int seq[maxn], sum[maxn], start[maxn];

int main(){
	int n, k = 0, flag = false;
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> seq[i];
		if(seq[i] >= 0) flag = true;
	}
	if(!flag){
		cout << "0 " << seq[0] << " " << seq[n-1];
		return 0 ;
	}
	
	sum[0] = seq[0];
	for(int i=1; i<n; i++){
		if(seq[i]+sum[i-1] > seq[i]){
			sum[i] = seq[i]+sum[i-1]; 
			start[i] = start[i-1]; // continue sequence
		}else{
			//reset sequence
			sum[i] = seq[i];
			start[i] = i;
		}
	}
	
	for(int i=1; i<n; i++){
		if(sum[i] > sum[k]){
			k=i;
		}
	}
	cout << sum[k] << " " << seq[start[k]] << " " << seq[k];
	return 0;
}

// finish at 14/01/20 14:28












