package offerDay.I.pass1.day07;

import utils.TreeNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Solution03 {
    /**
     * 剑指 Offer 27. 二叉树的镜像 - BFS
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRecur(root, root);
    }

    private boolean isSymmetricRecur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetricRecur(root1.left, root2.right) && isSymmetricRecur(root1.right, root2.left);
    }
}
