//2020-03-10 18:39:58
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans-1;
    }

    int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left+right+1, ans);
        return Math.max(left, right) + 1;
    }
}
//2020-03-10 18:56:05