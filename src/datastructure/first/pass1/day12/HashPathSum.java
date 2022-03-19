package datastructure.first.pass1.day12;

import utils.CompleteBinaryTree;
import utils.TreeNode;

/**
 * 112. 路径总和
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-10
 */
public class HashPathSum {
    static boolean flag = false;

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, null, null, 10, 11, null, null, null, null};
//        Integer[] array = {1, 2};
        int targetSum = 18;
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试
         */
        boolean hasPathSum = hasPathSum(completeBinaryTree.root, targetSum);
        System.out.println(hasPathSum);
    }

    /**
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。如果存在，返回 true；否则，返回 false
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int sum = root.val;
        dfs(root, targetSum, sum);
        return flag;
    }

    /**
     * 深度优先搜索-DFS：前序遍历-根左右
     *
     * @param root
     * @param targetSum
     * @param sum
     */
    public static void dfs(TreeNode root, int targetSum, int sum) {
        if (root.left != null) {
            dfs(root.left, targetSum, sum + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, sum + root.right.val);
        }
        if (root.left == null && root.right == null && sum == targetSum) {
            flag = true;
        }
        sum -= root.val;
    }
}
