import javax.swing.tree.TreeNode;

import org.graalvm.compiler.core.common.alloc.Trace;

//2020年07月30日10:02:23
/*
1.终止条件：
    1.1 当越过叶节点，则直接返回 null ；
    1.2 当 root 等于 p,q ，则直接返回 root；
2.递推工作：
    2.1 开启递归左子节点，返回值记为 left；
    2.2 开启递归右子节点，返回值记为 right ；
3.返回值： 根据 left 和 right ，可展开为四种情况；
    3.1 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
    3.2 当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
    3.3 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
        3.3.1 p,q 其中一个在 root 的 右子树 中，此时 right 指向 pp（假设为 p ）；
        3.3.2 p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
    3.4 当 left 不为空 ， right 为空 ：与情况 3. 同理；

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
class Solution {
    private TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p == root || q == root){ // 1
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 2.1
        TreeNode right = lowestCommonAncestor(root.right, p, q);// 2.2
        if(left == null && right == null){  //3.1
            return null;
        }
        if(left == null) return right;      //3.3
        if(right == null) return left;      //3.4
        return root;                        //3.2

    }
}
//2020-07-30 10:36:18