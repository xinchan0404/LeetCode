package offerDay.I.pass2.day19;

import utils.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution03 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}

class Solution03_ {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSub = dfs(root.left, p, q);
        boolean rightSub = dfs(root.right, p, q);
        if ((leftSub && rightSub) || ((root == p || root == q) && (leftSub || rightSub))) {
            ans = root;
        }
        return leftSub || rightSub || root == p || root == q;
    }
}
