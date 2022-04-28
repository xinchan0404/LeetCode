package offerDay.I.pass2.day18;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * @author xinchan
 * @version 1.0.1 2022-03-20
 */
public class Solution01 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            depth++;
            int size = deque.size();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}

class Solution01_ {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
