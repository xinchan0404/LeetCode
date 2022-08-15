package offerDay.I.pass1.day06;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @author xinchan
 * @version 1.0.1 2022-￥06-29
 */
public class Solution02 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode node;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
