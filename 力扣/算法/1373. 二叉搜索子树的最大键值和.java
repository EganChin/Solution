//2020-03-09 21:37:20
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        getMaxSumBST(root);
        return ans;
    }

    int getMaxSumBST(TreeNode root) {
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return sumBST(root);
        }else{
            int left = getMaxSumBST(root.left);
            int right = getMaxSumBST(root.right);
            return Math.max(left, right);
        }
    }


    int sumBST(TreeNode root){
        if(root == null)
            return 0;
        int sum = root.val + sumBST(root.left) + sumBST(root.right);
        ans = Math.max(sum, ans);
        return sum;
    }

    boolean isBST(TreeNode root, int left, int right){
        if(root==null) return true;
        return root.val > left && root.val < right
            && isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
    }
}

//2020-03-09 22:09:25