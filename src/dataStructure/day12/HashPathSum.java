package dataStructure.day12;

import dataStructure.utils.CompleteBinaryTree;
import dataStructure.utils.TreeNode;

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
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, null, null, 10, 11, null, null, null, null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试
         */
        boolean flag = hasPathSum(completeBinaryTree.root, 10);
        System.out.println(flag);
    }

    /**
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。如果存在，返回 true；否则，返回 false
     *
     * @param root
     * @param targetSum
     * @return
     */
    static int sum = 0;
    static boolean flag = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum);
        return flag;
    }

    public static void dfs(TreeNode root, int tatgetSum) {
        sum += root.val;
        if (root.left != null) {
            dfs(root.left, tatgetSum);
        }
        if (root.right != null) {
            dfs(root.right, tatgetSum);
        }
        if (sum == tatgetSum) {
            flag = true;
        } else {
            sum -= root.val;
        }
    }
}
