#include <iostream>
#include <vector>
#include <map>
#include <cmath>
#include <algorithm>
using namespace std;

/**
�۲��λ���Ĳ�ֳ˻�
7: 2*3*3=18
6: 3*3 = 9
5: 2*3 = 6
4: 2*2 = 4
3: 2*1 = 2
���Կ�����Ͳ�3ʹ�ó˻�������� �����ܶ���3
�������������Է�Ϊ3�����
��0�����ò��ֱ꣬�ӷ���3��n�η�
��1����һ��1+3���2+2.����3��n�η���һ����4
��2������3��n�η�����2�ĳ˻���2���������²�֣� 

������nС�ڵ���3.������ĿҪ����뽫���֣�����n-1 
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
