// begin at 2020-02-11 22:57:26 

#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    bool findNumberIn2DArray(vector<vector<int>>& matrix, int target) {
    	if(matrix.size() == 0 || matrix[0].size() == 0) return 0;
        int n = matrix.size(), m = matrix[0].size();
        int row = 0, col = m-1;
        while(row < n && col >= 0){
        	if(matrix[row][col] < target) row++;
        	else if(matrix[row][col] == target) return true;
        	else col--;

		}
		return false;
    }
};

int main(){
//	vector<vector<int>> nums {{
//  {1,   4,  7, 11, 15},
//  {2,   5,  8, 12, 19},
//  {3,   6,  9, 16, 22},
//  {10, 13, 14, 17, 24},
//  {18, 21, 23, 26, 30}
//}
//};
	vector<vector<int>> nums {{-5}};
	Solution *s = new Solution();
	cout << s->findNumberIn2DArray(nums, -5) << endl;
	return 0;
}

// finish at 2020-02-11 23:19:45 
