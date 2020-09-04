import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//2020-09-04 13:42:43
class Solution {
    private List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return paths;
    }

    private void dfs(TreeNode node, String path){
        if(node != null){
            if(node.left==null && node.right==null){
                paths.add(path+node.val);
            }else{
                path+=node.val+"->";
                dfs(node.left, path);
                dfs(node.right, path);
            }
        }
            
    }
}
//2020-09-04 13:49:24