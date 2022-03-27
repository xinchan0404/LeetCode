package tencent.top10.pass2;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2022-03-27
 */
public class Solution06 {
    private List<List<Integer>> paths;
    private List<Integer> path;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        this.paths = new ArrayList<>();
        this.path = new ArrayList<>();
        this.used = new boolean[n];

        backTrace(nums, n);
        return paths;
    }

    private void backTrace(int[] nums, int n) {
        if (path.size() == nums.length) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrace(nums, n);
                path.remove((Integer) nums[i]);
                used[i] = false;
            }
        }
    }
}
