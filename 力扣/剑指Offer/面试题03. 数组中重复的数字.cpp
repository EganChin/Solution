// begin at 2020-02-11 22:02:02
#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        map<int,bool> m;
		for(auto i : nums){
    		if(m.find(i) != m.end()){
    			return i;
			}
			m[i] = true;
		}
		return -1;
    }
};

int main(){
	vector<int> nums {2, 3, 1, 0, 4, 5, 3};
	Solution *s = new Solution();
	int result = s->findRepeatNumber(nums);
	cout << result << endl;
	return 0;
}

// finish at 2020-02-11 22:07:14 
