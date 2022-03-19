package offerDay.first.pass2.day15;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution03 {
    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(list.size() - k);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }

    private int ans = -1;
    private int k;
    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点 - 提前返回
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        inorder1(root);
        return ans;
    }

    private void inorder1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            inorder1(root.right);
        }
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            ans = root.val;
        }
        if (root.left != null) {
            inorder1(root.left);
        }
    }

}
