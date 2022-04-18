package tencent.top50;

import java.util.Arrays;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-17
 */
public class Solution16 {
<<<<<<< HEAD
    private int target;
=======
>>>>>>> 47d8bc6f27f5631401af98d415ff45b883ed42b0
    private int diff = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
<<<<<<< HEAD
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            twoSum(nums, left, right);
            if (diff == 0) break;
            left++;
=======
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, n - 1, target);
            if (diff == 0) {
                break;
            }
>>>>>>> 47d8bc6f27f5631401af98d415ff45b883ed42b0
        }
        return target - diff;
    }

    private void twoSum(int[] nums, int left, int right, int target) {
        int val = nums[left++];
        while (left < right) {
            int tmp = target - (val + nums[left] + nums[right]);
<<<<<<< HEAD
            if (Math.abs(tmp) < Math.abs(diff)) {
                diff = tmp;
            }
=======
>>>>>>> 47d8bc6f27f5631401af98d415ff45b883ed42b0
            if (tmp < 0) {
                if (-tmp < Math.abs(diff)) {
                    diff = tmp;
                }
                right--;
            } else if (tmp > 0) {
                if (tmp < Math.abs(diff)) {
                    diff = tmp;
                }
                left++;
            } else {
                diff = tmp;
                return;
            }
        }
    }
}
