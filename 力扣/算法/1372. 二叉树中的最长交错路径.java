//2020-03-09 21:10:19
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
    int ans=0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, -1, 1);
        dfs(root.right, 1, 1);
        return ans;
    }

    public void dfs(TreeNode node, int r, int l){
        if(node == null)
            return;
        ans = Math.max(ans, l);
        dfs(r==-1?node.right:node.left, r*-1, l+1);
        dfs(r==-1?node.left:node.right, r, 1);
    }
}
//2020-03-09 21:34:32