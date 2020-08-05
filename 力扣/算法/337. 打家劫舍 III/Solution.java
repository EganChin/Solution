import java.util.HashMap;

//2020-08-05 13:42:23
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
    private Map<TreeNode, Integer> f = new HashMap<>();  //f(o) select node o
    private Map<TreeNode, Integer> g = new HashMap<>();  //f(o) unselect node o
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val+g.getOrDefault(node.left, 0)+g.getOrDefault(node.right, 0));
        g.put(node, Math.max(g.getOrDefault(node.left, 0), f.getOrDefault(node.left, 0))
        + Math.max(g.getOrDefault(node.right, 0), f.getOrDefault(node.right, 0))
        );
    }
}
//2020-08-05 14:07:20 ERROR g.put不应该在加上当前节点的值，因为g本身就代表不选择当前节点
//2020-08-05 14:11:43 AC