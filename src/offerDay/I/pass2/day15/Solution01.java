package offerDay.I.pass2.day15;

import utils.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution01 {
    private int sum;
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return lists;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, target);
        }
        if (root.right != null) {
            dfs(root.right, target);
        }
        if (root.left == null && root.right == null && sum == target) {
            lists.add(new ArrayList<>(list));
        }
        sum -= root.val;
        list.remove(list.size() - 1);
    }
}

class Solution01_ {
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> sum = new ArrayDeque<>();
        deque.offer(root);
        sum.offer(0);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            int cur = sum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (cur == target) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    deque.offer(node.left);
                    sum.offer(cur);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    deque.offer(node.right);
                    sum.offer(cur);
                }
            }
        }
        return lists;
    }

    private void getPath(TreeNode node) {
        List<Integer> path = new ArrayList<>();
        while (node != null) {
            path.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(path);
        lists.add(new ArrayList<>(path));
    }
}