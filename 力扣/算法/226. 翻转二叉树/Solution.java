/*
226. 翻转二叉树 re.0 i E
T: 2020-09-16 15:38:05 - 2020-09-16 15:43:44

Q: 翻转一棵二叉树。

A:先序遍历交换当前node的左右节点
*/

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    public void preOrder(TreeNode node){
        if(node != null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}