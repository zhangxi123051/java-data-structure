package com.tencent.algorithm.leetcode.tree;


import com.tencent.algorithm.leetcode.util.TreeNode;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S437 {

    public static void main(String[] args) {
        S437.Solution solution = new S437().new Solution();
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(solution.pathSum(root,6));

    }


    class Solution {
        public int pathSum(TreeNode root, int sum) {
            if(root == null){
                return 0;
            }
            int result = countPath(root,sum);
            int a = pathSum(root.left,sum);
            int b = pathSum(root.right,sum);
            return result+a+b;

        }
        public int countPath(TreeNode root,int sum){
            if(root == null){
                return 0;
            }
            sum = sum - (Integer)root.val;
            int result = sum == 0 ? 1:0;
            return result + countPath(root.left,sum) + countPath(root.right,sum);
        }
    }


    class Solution3 {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            int res = 0;
            // 遍历每个节点，并且将每一个节点都过一遍 countPath()，将所有节点的有效路径加起来
            res += countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

            return res;
        }

        /*
            计算从某一个节点出发一共能有多少条路径
        */
        public int countPath(TreeNode<Integer> root, int sum) {
            if (root == null) {
                return 0;
            }

            int count = 0;

            if (root.val == sum) {
                ++count;
            }

            int leftCount = countPath(root.left, sum - root.val);
            int rightCount = countPath(root.right, sum - root.val);
            count += leftCount + rightCount;

            return count;
        }
    }


    class Solution2 {
        int result =0;

        public int sum(TreeNode root, int targetSum) {
            dfs(root,targetSum);
            dfs(root.left,targetSum);
            dfs(root.right,targetSum);
            return result;
        }


        public void dfs(TreeNode<Integer> root,int sum) {

            if(root == null) return;

            //后续遍历的模式
            sum=sum-root.val;

            if(sum==0){
                result=result+1;
            }

            dfs(root.left,sum);
            dfs(root.right,sum);


            return;

        }

    }
}
