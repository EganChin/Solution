import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
501. 二叉搜索树中的众数 re.0 ui E?
T: 2020-09-24 15:05:07 - 2020-09-24 15:35:40

Q: 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
提示：如果众数超过1个，不需考虑输出顺序
进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

A:BST可以通过中序遍历得到一个有序序列，其中相同的数一定是相邻的。
因此可以利用中序遍历，每次遍历更新当前数出现的频率，具体策略如下
设前一个遍历的数为base，当前数为x，当前数出现的频率为count，目前的最大频率为maxCount
每次更新先比较base和x,如果相等，count自增，否则base设为x，count复位1
然后比较count和maxCount，如果相等，将x加入数组
如果count>maxCount，清空数组，maxCount设为count，将x加入数组。
*/
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

    private Integer base = null, count=0, maxCount=0;

    private List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        midOrder(root);

        int [] a = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            a[i] = ans.get(i);
        return a;
    }

    private void midOrder(TreeNode node){
        if(node != null){
            midOrder(node.left);
            update(node.val);
            midOrder(node.right);
        }
    }

    private void update(int x){
        if(base == null){
            base = x;
            ans.add(x);
            count = maxCount = 1;
        }else{
            if(base == x){
                count++;
            }else{
                base = x;
                count = 1;
            }

            if(maxCount == count){
                ans.add(x);
            }else if(maxCount < count){
                maxCount = count;
                ans.clear();
                ans.add(x);
            }
        }
    }

}