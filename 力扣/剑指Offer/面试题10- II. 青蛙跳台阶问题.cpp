// begin at 2020-02-11 22:33:24 

#include <iostream>
using namespace std;

class Solution {
public:
	int numWays(int n) {
		int a = 1, b = 1, c = n >= 2 ? a+b : a;
        for(int i=2; i<=n; i++){
        	c = (a + b) % 1000000007;
        	a = b;
        	b = c;
		}
		return c;
    }
};

int main(){
	Solution *s = new Solution();
	cout << s->fib(7) << endl;
	return 0;
}
