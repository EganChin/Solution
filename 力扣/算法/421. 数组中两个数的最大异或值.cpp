//
// Created by Administrator on 2019/12/30.
//

// begin at 2019/12/30 16:56

#include <iostream>
#include <vector>
#include <map>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
    	int result = 0, mask = 0;
    	unordered_set<int> prefix_set;
    	for(auto num : nums){
    		prefix_set.insert(mask & num);
		}
    	for(int i=31; i>=0; i--){
    		mask |= (1<<i);
			int temp = result | (1<<i);
			for(auto prefix : prefix_set){
				if(prefix_set.count(prefix ^ temp)){
					result = temp;
					break;
				}
			}
		}
		return result;
    }
};

int main(){
    vector<int> nums {4,6,7};
    Solution *s = new Solution();
    cout <<  s->findMaximumXOR(nums) << endl;
    return 0;
}

// finish at 2019/12/30 17:38
