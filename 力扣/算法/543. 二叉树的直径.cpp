//
// Created by Administrator on 2019/12/31.
//

// begin at 2019/12/31 11:30

#include <cstdio>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	int ans;
    int diameterOfBinaryTree(TreeNode *root) {
    	ans = 1;
    	dfs(root);
    	return ans-1;
    }
    
    int dfs(TreeNode *node){
    	if(!node)	return 0;
    	int l = dfs(node->left);
    	int r = dfs(node->right);
    	ans = max(ans, l+r+1);
    	return max(l,r)+1;
	}
};


TreeNode* genTree(vector<int> nums){
	TreeNode* root = new TreeNode(nums[1]);
	
	queue<TreeNode *> q;
    TreeNode *front;

	int i=2;
    q.push(root);

    while (!q.empty())
    {
        front = q.front();
        q.pop();

        if (i<nums.size()){
        	front->left = new TreeNode(nums[i++]);
        	q.push(front->left);
		}


        if (i<nums.size()){
        	front->right = new TreeNode(nums[i++]);
        	q.push(front->right);
        }
    }
    return root;
}

int main(){

	Solution *s = new Solution;
	
	
	printf("%d", s->diameterOfBinaryTree(genTree(vector<int>{-1,1,2,3,4,5,6}))) ;

    return 0;
}

// finish at 2019/12/31 14:21