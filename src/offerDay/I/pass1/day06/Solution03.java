package offerDay.I.pass1.day06;

import utils.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @author xinchan
 * @version 1.0.1 2022-￥06-29
 */
public class Solution03 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> level = new LinkedList<>();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = deque.poll();
                if (flag) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            levels.add(level);
            flag = !flag;
        }
        return levels;
    }
}
