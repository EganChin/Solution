// begin at 2020-02-11 22:53:37 

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minArray(vector<int>& numbers) {
    	int min = numbers[0];
        for(int i = 0; i<numbers.size()-1; i++){
        	if(min > numbers[i+1]){
        		return numbers[i+1];
			}
		}
    }
};

int main(){
	vector<int> nums {3,4,5,1,2};
	Solution *s = new Solution();
	cout << s->minArray(nums) << endl;
	return 0;
}

// finish at 2020-02-11 22:55:14 
