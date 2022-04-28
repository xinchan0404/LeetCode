package offerDay.I.pass2.day15;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution03 {
    private List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }


    private int cnt;
    private int ans;
    public int kthLargest1(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            dfs(root.right, k);
        }
        if (++cnt == k) {
            ans = root.val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, k);
        }
    }
}
