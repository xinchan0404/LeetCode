package codingInterviewDay_2.day15;

import utils.TreeNode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution01 {
    private int sum;
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int cnt;

    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        pathSumRecur(root, target);
        return lists;
    }

    private void pathSumRecur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        cnt++;
        sum += root.val;
        list.add(root.val);
        pathSumRecur(root.left, target);
        pathSumRecur(root.right, target);
        if (root.left == null && root.right == null && sum == target) {
            lists.add(new ArrayList<>(list));
        }
        cnt--;
        sum -= root.val;
        list.remove(cnt);
    }
}
