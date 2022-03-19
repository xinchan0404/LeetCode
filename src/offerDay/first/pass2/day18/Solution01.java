package offerDay.first.pass2.day18;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution01 {
    /**
     * 剑指 Offer 55 - I. 二叉树的深度 - BFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int deep = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode node;
            deep++;
            for (int i = 0; i < size; i++) {
                node = deque.remove();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return deep;
    }

    private int deep;
    private int maxDeep;
    /**
     * 剑指 Offer 55 - I. 二叉树的深度 - DFS
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        dfs(root);
        return maxDeep;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        deep++;
        if (root.left == null && root.right == null) {
            maxDeep = Math.max(deep, maxDeep);
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        deep--;
    }

    /**
     * 剑指 Offer 55 - I. 二叉树的深度 - DFS
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
