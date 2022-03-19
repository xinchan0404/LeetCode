package offerDay.first.pass2.day06;

import utils.TreeNode;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Solution03 {
    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> level = new LinkedList<>();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = deque.remove();
                if (flag) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            flag = !flag;
            levels.add(level);
        }
        return levels;
    }
}
