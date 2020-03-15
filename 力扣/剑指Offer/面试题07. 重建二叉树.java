/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//2020-03-15 16:56:39
 /*
 9,20,15,7
 9 15,20,7
 null       15 7
 */
class Solution {
    int[] pre;
    int[] in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        return buildTree(0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int mid = inL;
        while (in[mid] != pre[preL] && mid <= inR) {
            mid++;
        }
        int numLeft = mid - inL;
        root.left = buildTree(preL + 1, preL + numLeft, inL, mid - 1);
        root.right = buildTree(preL + numLeft + 1, preR, mid + 1, inR);

        return root;
    }
}

//2020-03-15 17:16:48