package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * @author xinchan
 * @version 1.0.1 2022-09-17
 */
public class Solution04 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(0, nums);
        return null;
    }

    private void subsets(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        subsets(cur + 1, nums);
        list.remove(list.size() - 1);
        subsets(cur + 1, nums);
    }

    public static void main(String[] args) {
        Solution04 s4 = new Solution04();
        int[] nums = {1,2,3,4,5,6};
        List<List<Integer>> subsets = s4.subsets(nums);
        System.out.println(subsets);
    }
}
