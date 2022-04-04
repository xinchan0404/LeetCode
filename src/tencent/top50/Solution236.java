package tencent.top50;

import utils.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution236 {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         recur(root, p, q);
         return ans;
    }

    private boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isLeft = recur(root.left, p, q);
        boolean isRight = recur(root.right, p, q);
        if ((isLeft && isRight) || ((root == p || root == q) && (isLeft || isRight))) {
            ans = root;
        }
        return root == p || root == q || isLeft || isRight;
    }
}

class Solution236_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.left, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
