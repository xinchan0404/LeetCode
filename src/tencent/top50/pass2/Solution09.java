package tencent.top50.pass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author xinchan
 * @version 1.0.1 2022-08-18
 */
public class Solution09 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);

        int n = nums.length;
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
            int sum = nums[left] + nums[right];
            int origin = nums[left];
            if (sum == target) {
                lists.add(Arrays.asList(-target, nums[left], nums[right]));
                while (left < right && nums[left] == origin) {
                    left++;
                }
                right--;
            } else if (sum < target) {
                while (left < right && nums[left] == origin) {
                    left++;
                }
            } else {
                right--;
            }
        }
        return lists;
    }
}
