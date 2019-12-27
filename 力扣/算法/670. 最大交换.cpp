//
// Created by Administrator on 2019/12/27.
//

#include <iostream>
#include<vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	int last[10], len = 0;
	vector<int> d;
	
	void swap(int &a, int &b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	void digit(int n){
		int i = 0;
		while(n){
			d.push_back(n%10);
			if(last[n%10] == -1)
				last[n%10] = len;
			len++;
			n/=10;
		}
		for(int i=0;i<10; i++){
			if(last[i]!=-1)
				last[i] = len - last[i]-1;
		}
		reverse(d.begin(), d.end());
	}
	
    int maximumSwap(int num) {
    	fill(last, last+10, -1);
    	digit(num);
    	for(int i=0, j=9; i<d.size(); i++){
    		int num = d[i];
    		//find the first number greater than current from back
			while(last[j] == -1 || last[j] < i){
				j--;
			}
    		if(j > num){
    			swap(d[i], d[last[j]]);
    			break;
			}
		}
		int result = 0;
		for(int i=d.size()-1, j=1; i>=0; i--, j*=10){
			result = result + (d[i]*j);
		}
		return result;
    }
};

int main(){
    Solution *s = new Solution();
    cout << s->maximumSwap(9738) << endl;
    return 0;
}

// finish at 2019/12/27 16:28