package tencent.top50.pass3;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2023-02-24
 */
public class Solution16 {
    private List<List<Integer>> lists;
    private List<Integer> list;
    private boolean[] used;
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        this.lists = new ArrayList<>();
        this.list = new ArrayList<>();
        this.n = nums.length;
        this.used = new boolean[n];

        recur(nums);

        return lists;
    }

    private void recur(int[] nums) {
        if (list.size() == n) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                recur(nums);
                used[i] = false;
                list.remove((Integer) nums[i]);
            }
        }
    }
}
