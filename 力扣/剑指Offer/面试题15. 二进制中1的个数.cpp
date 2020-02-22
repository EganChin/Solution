// begin at 2020-02-22 10:02:38 
#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int d = 0;
        while(n){
        	n&=(n-1);
        	d++;
		}
		return d;
    }
};

int main(){
	Solution *s = new Solution();
	int result = s->hammingWeight(11);
	cout << result << endl;
	return 0;
}

// finish at 2020-02-22 10:18:00 
