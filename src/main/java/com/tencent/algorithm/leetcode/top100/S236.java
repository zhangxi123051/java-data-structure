package com.tencent.algorithm.leetcode.top100;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
// 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
//
//
// 示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//
// 示例 2：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//
// 示例 3：
//
//
//输入：root = [1,2], p = 1, q = 2
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 105] 内。
// -109 <= Node.val <= 109
// 所有 Node.val 互不相同 。
// p != q
// p 和 q 均存在于给定的二叉树中。
//
// Related Topics 树
// 👍 956 👎 0


/*
解题思路：
祖先的定义： 若节点 pp 在节点 rootroot 的左（右）子树中，或 p = rootp=root ，则称 rootroot 是 pp 的祖先。



最近公共祖先的定义： 设节点 rootroot 为节点 p, qp,q 的某公共祖先，若其左子节点 root.leftroot.left 和右子节点 root.rightroot.right 都不是 p,qp,q 的公共祖先，则称 rootroot 是 “最近的公共祖先” 。

根据以上定义，若 rootroot 是 p, qp,q 的 最近公共祖先 ，则只可能为以下情况之一：

pp 和 qq 在 rootroot 的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
p = rootp=root ，且 qq 在 rootroot 的左或右子树中；
q = rootq=root ，且 pp 在 rootroot 的左或右子树中；


考虑通过递归对二叉树进行后序遍历，当遇到节点 pp 或 qq 时返回。从底至顶回溯，当节点 p, qp,q 在节点 rootroot 的异侧时，节点 rootroot 即为最近公共祖先，则向上返回 rootroot 。

递归解析：
终止条件：
当越过叶节点，则直接返回 nullnull ；
当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
递推工作：
开启递归左子节点，返回值记为 leftleft ；
开启递归右子节点，返回值记为 rightright ；
返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；

作者：jyd
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.*;

public class S236{
    public static void main(String[] args) {
        Solution solution = new S236().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null && right == null) return null; // 1.
            if(left == null) return right; // 3.
            if(right == null) return left; // 4.
            return root; // 2. if(left != null and right != null)
        }
    }

    class Solution2{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //记录遍历到的每个节点的父节点。
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            parent.put(root, null);//根节点没有父节点，所以为空
            queue.add(root);
            //直到两个节点都找到为止。
            while (!parent.containsKey(p) || !parent.containsKey(q)) {
                //队列是一边进一边出，这里poll方法是出队，
                TreeNode node = queue.poll();
                if (node.left != null) {
                    //左子节点不为空，记录下他的父节点
                    parent.put(node.left, node);
                    //左子节点不为空，把它加入到队列中
                    queue.add(node.left);
                }
                //右节点同上
                if (node.right != null) {
                    parent.put(node.right, node);
                    queue.add(node.right);
                }
            }
            Set<TreeNode> ancestors = new HashSet<>();
            //记录下p和他的祖先节点，从p节点开始一直到根节点。
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }
            //查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点……
            while (!ancestors.contains(q))
                q = parent.get(q);
            return q;
        }
    }




    class Solution3 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }

            if(root ==p || root==q) return root;

            TreeNode left= lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
