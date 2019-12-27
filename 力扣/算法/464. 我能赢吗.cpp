//
// Created by Administrator on 2019/12/27.
//

// begin at 2019/12/27 13:37

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <bitset>
using namespace std;

class Solution {
public:

    bitset<1<<20> used, val;

    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        int max = maxChoosableInteger, tar = desiredTotal;
        if(tar > (max*(max+1)/2))   return false;
        if(tar < max) return true;
        return helper(max, tar, 0);
    }

    bool helper(int max, int tar, int mask){
    	cout << used[mask] << ":" << val[mask] << endl;
        if(used[mask]) return val[mask];
        for(int i=max, cur=1; i>0; i--, cur<<=1)
        	if(!(mask & cur))
        		if(i>=tar || !helper(max, tar-i, mask|cur))
        			return used[mask] = val[mask] = 1;
        used[mask] = 1, val[mask] = 0 ;
        return false;
        			
    }
};

int main(){
    Solution *s = new Solution();
    cout << s->canIWin(10, 11) << endl;
    return 0;
}

// finish at 2019/12/27 14:48