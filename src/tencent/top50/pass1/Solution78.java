package tencent.top50.pass1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 78. 子集
 * @author xinchan
 * @version 1.0.1 2022-04-23
 */
public class Solution78 {
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean[] used = new boolean[n];
            recall(nums, used, i);
        }
        return lists;
    }

    private void recall(int[] nums, boolean[] used, int k) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                recall(nums, used, k);
                used[i] = false;
                list.remove((Integer) nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        System.out.println(subsets);
    }
}
