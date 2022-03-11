package codingInterviewDay_2.day18;

import utils.TreeNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution02 {
    /**
     * 剑指 Offer 55 - II. 平衡二叉树 - 自顶向下，有大量重复计算
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getDeep(root.left) - getDeep(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }

    /**
     * 剑指 Offer 55 - II. 平衡二叉树 - 自底向上，剪枝
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
