package tencent.top50.pass3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author xinchan
 * @version 1.0.1 2023-02-21
 */
public class Solution8 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length, pre = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lists.addAll(twoSum(nums, i + 1, n - 1, -nums[i]));
        }

        return lists;
    }

    private List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        while (left < right) {
            int tmp = nums[left] + nums[right];
            int origin = nums[left];
            if (tmp == target) {
                List<Integer> list = Arrays.asList(nums[left], nums[right], -target);
                lists.add(list);
                while (left < right && nums[left] == origin) {
                    left++;
                }
                right--;
            } else if (tmp > target) {
                right--;
            } else {
                while (left < right && nums[left] == origin) {
                    left++;
                }
            }
        }

        return lists;
    }
}
