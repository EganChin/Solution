#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	map<int,int> m;
    	for(int i=0; i<nums.size(); i++){
    		int a = nums.at(i);
    		if(m.find(a) != m.end()){
    			nums.clear();
    			nums.push_back(m[a]);
    			nums.push_back(i);
    			break;
			}
			m[target-a] = i;
		}
		return nums;
    }
};

int main(){
	vector<int> nums {3,3};
	Solution *s = new Solution();
	vector<int> result = s->twoSum(nums, 6);
	for(auto & i : result){
		cout << i << endl;
	}
	return 0;
}
