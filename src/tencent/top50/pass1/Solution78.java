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
            int idx = 0;
            recall(nums, used, i, idx);
        }
        return lists;
    }

    private void recall(int[] nums, boolean[] used, int k, int idx) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && i >= idx) {
                idx = i + 1;
                used[i] = true;
                list.add(nums[i]);
                recall(nums, used, k, idx);
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

class Solution78_ {
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return lists;
    }

    private void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(nums, cur + 1);
        list.remove(list.size() - 1);
        dfs(nums, cur + 1);
    }
}
