package offerDay.I.pass1.day06;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author xinchan
 * @version 1.0.1 2022-￥06-29
 */
public class Solution01 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
