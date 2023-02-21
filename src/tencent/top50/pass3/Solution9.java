package tencent.top50.pass3;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author xinchan
 * @version 1.0.1 2023-02-22
 */
public class Solution9 {
    private int ans = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, n - 1, target);
            if (ans == 0) {
                return target;
            }
        }

        return ans + target;
    }

    private void twoSum(int[] nums, int left, int right, int target) {
        int num = nums[left++];
        while (left < right) {
            int tmp = nums[left] + nums[right] + num;
            if (tmp == target) {
                ans = 0;
                return;
            } else if (tmp > target) {
                if (Math.abs(ans) > tmp - target) {
                    ans = tmp - target;
                }
                right--;
            } else {
                if (Math.abs(ans) > target - tmp) {
                    ans = tmp - target;
                }
                left++;
            }
        }
    }
}
