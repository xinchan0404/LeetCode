package offerDay.first.pass2.day06;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Solution01 {
    /**
     * 面试题32 - I. 从上到下打印二叉树
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        int size = list.size();
        int[] levelOrder = new int[size];
        for (int i = 0; i < size; i++) {
            levelOrder[i] = list.get(i);
        }

        return levelOrder;
    }
}
