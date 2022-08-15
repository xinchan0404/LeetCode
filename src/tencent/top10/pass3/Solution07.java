package tencent.top10.pass3;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xinchan
 * @version 1.0.1 2022-08-05
 */
public class Solution07 {
    private List<List<Integer>> lists;
    private List<Integer> list;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        this.lists = new ArrayList<>();
        this.list = new ArrayList<>();
        this.used = new boolean[n];

        recall(nums);

        return lists;
    }

    private void recall(int[] num) {
        if (list.size() == num.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                list.add(num[i]);
                used[i] = true;
                recall(num);
                list.remove((Integer) num[i]);
                used[i] = false;
            }
        }
    }
}
