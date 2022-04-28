package offerDay.I.pass2.day18;

import utils.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * @author xinchan
 * @version 1.0.1 2022-03-20
 */
public class Solution02 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) == -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = depth(root.left);
        }
        if (root.right != null) {
            rightDepth = depth(root.right);
        }
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
