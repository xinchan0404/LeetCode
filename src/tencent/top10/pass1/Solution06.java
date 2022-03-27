package tencent.top10.pass1;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution06 {
    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        this.used = new boolean[nums.length];
        backTrace(nums);
        return paths;
    }

    private void backTrace(int[] nums) {
        if (nums.length == path.size()) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrace(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
