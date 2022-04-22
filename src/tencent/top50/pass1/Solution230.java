package tencent.top50.pass1;

import utils.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution230 {
    private int ans;
    private int cnt;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, k);
        }
        if (++cnt == k) {
            ans = root.val;
            return;
        }
        if (root.right != null) {
            inorder(root.right, k);
        }
    }
}
