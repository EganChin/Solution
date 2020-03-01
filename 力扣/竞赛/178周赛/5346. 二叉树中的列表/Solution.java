

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

 // begin at 2020/3/1 11:44
 class Solution {
     public boolean isSubPath(ListNode head, TreeNode root) {
         if(head == null)
             return true;
         if(root == null)
             return false;
         return dfs(head,root) || isSubPath(head, root.left) || isSubPath(head, root.right);
     }

     public boolean dfs(ListNode head, TreeNode root){
         if(root == null){
             return false;
         }if(head == null){
             return true;
         }

         if(head.val != root.val){
             return false;
         }

         return dfs(head.next, root.left) || dfs(head.next, root.right);
     }
 }
/// finish at 2020/3/1 13:33