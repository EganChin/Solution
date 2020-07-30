import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.tree.TreeNode;

//2020-07-30 10:53:30
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    private String ans = "";
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        TreeNode nullNode = new TreeNode(-1);
        preOrder(root);
        if(!ans.equals(""))
            ans = ans.substring(0, ans.length()-1);
        return ans;
    }
    private void preOrder(TreeNode node){
        if(node != null){
            ans += node.val + ",";
            preOrder(node.left);
            preOrder(node.right);
        }else{
            ans += "null,";
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if(data.equals("")) return null;
        return createNode(new LinkedList<String>(Arrays.asList(data.split(","))));
    }

    private TreeNode createNode(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = createNode(list);
        root.right = createNode(list);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//2020-07-30 14:52:34