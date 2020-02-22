// begin at 2020-02-22 10:56:56 

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <queue>
using namespace std;

int n ;



struct TreeNode {
    int val;
     TreeNode *left;
     TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 
 void BFS(TreeNode *root) {
    queue<TreeNode *> q;
    q.push(root);
    for (int i = 0; !q.empty(); i++) {
        TreeNode *node = q.front();
        q.pop();
        printf("%d", node->val);
        if (i != n - 1)
            printf(" ");
        if (node->left != NULL)
            q.push(node->left);
        if (node->right != NULL)
            q.push(node->right);
    }
}

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    	pre = preorder;
    	in = inorder;
    	int n = in.size();
    	return this->buildTree(0, n-1, 0, n-1);
    }
private:
	vector<int> pre, in;
	
	TreeNode* buildTree(int preL, int preR, int inL, int inR){
    	if(preL > preR){
    		return NULL;
		}
		TreeNode * root = new TreeNode(pre[preL]);
		
		int midpos = inL;
		for(;midpos <= inR; midpos++){
			if(in[midpos] == pre[preL])
				break;
		}
		
		int numLeft = midpos - inL;
//		BFS(root);
		root->left = buildTree(preL+1, preL + numLeft, inL, midpos - 1);
//		BFS(root);
		root->right = buildTree(preL + numLeft+1, preR, midpos+1, inR);
		
		return root;
	}
};




int main(){
	vector<int> pre {3,9,20,15,7};
	vector<int> in {9,3,15,20,7};
	n = in.size();
	Solution *s = new Solution();
	TreeNode* result = s->buildTree(pre , in);

	return 0;
}
