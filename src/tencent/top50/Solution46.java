package tencent.top50;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution46 {
    private List<List<Integer>> paths;
    private List<Integer> path;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return paths;
        }
        int n = nums.length;
        paths = new ArrayList<>();
        path = new ArrayList<>();
        boolean[] used = new boolean[n];
        recur(nums, used);
        return paths;
    }

    private void recur(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            recur(nums, used);
            used[i] = false;
            path.remove((Integer)(nums[i]));
        }
    }
}
