#include <iostream>
#include <vector>
#include <map>
#include <cmath>
#include <algorithm>
using namespace std;

/**
观察个位数的拆分乘积
7: 2*3*3=18
6: 3*3 = 9
5: 2*3 = 6
4: 2*2 = 4
3: 2*1 = 2
可以看出最低拆到3使得乘积最大，所以 尽可能多拆出3
拆完后的余数可以分为3种情况
余0，正好拆完，直接返回3的n次方
余1，将一个1+3拆成2+2.返回3的n次方减一乘以4
余2，返回3的n次方乘以2的乘积（2不可能往下拆分） 

最后，如果n小于等于3.按照题目要求必须将其拆分，返回n-1 
**/
class Solution {
public:
    int integerBreak(int n) {
    	if(n<=3)
    		return n-1;
        int a = n/3;
        int b = n%3;
        if(b == 0)
        	return pow(3, a);
        else if(b==1)
			return pow(3,a-1)*4; 
		return pow(3,a)*2; 

    }
};

int main(){

	Solution *s = new Solution();
	int len = s->integerBreak(8);
	printf("%d\n", len);
	return 0;
}
