import javax.swing.tree.TreeNode;

/*
701. 二叉搜索树中的插入操作 re.0 i M
T: 2020-09-30 14:52:15 - 2020-09-30 14:59:05

Q: 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 
返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

A:根据bst规律插入即可。
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while(true){
            if(node == null){
                return new TreeNode(val);
            }
            if(node.val < val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    break;
                }else{
                    node = node.right;
                }
            }
            else{
                if(node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }else{
                    node = node.left;
                }
            }
        }
        return root;
    }
}