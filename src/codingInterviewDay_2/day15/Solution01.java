package codingInterviewDay_2.day15;

import utils.TreeNode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution01 {
    private int sum;
    List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return lists;
    }

    private void dfs(TreeNode root , int target) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum += root.val;
        dfs(root.left, target);
        dfs(root.right, target);
        if (root.left == null && root.right == null && sum == target) {
            lists.add(new ArrayList<>(list));
        }
        sum -= root.val;
        list.remove(list.size() - 1);
    }
}
