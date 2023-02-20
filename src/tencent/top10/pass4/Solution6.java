package tencent.top10.pass4;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution6 {
    private List<List<Integer>> lists;
    private List<Integer> list;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        this.lists = new ArrayList<>();
        this.list = new ArrayList<>();
        this.used = new boolean[n];

        recur(nums);

        return lists;
    }

    private void recur(int[] nums) {
        int n = nums.length;
        if (list.size() == n) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                recur(nums);
                list.remove((Integer) nums[i]);
                used[i] = false;
            }
        }
    }
}
