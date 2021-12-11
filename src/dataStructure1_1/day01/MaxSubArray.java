package dataStructure1_1.day01;

import java.util.Arrays;

/**
 * 最大子序和
 * 提示：
 * 1. 1 <= nums.length <= 105
 * 2. -104 <= nums[i] <= 104
 *
 * @author xinchan
 * @version 1.0.1 2021-11-25
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -9, -3, -1, -1, -5, -4};
        int maxSubArray = 0;

//        maxSubArray = maxSubArray(nums);
//        maxSubArray = maxSubArray1(nums);
        maxSubArray = maxSubArray2(nums);

        System.out.println("maxSubArray=" + maxSubArray);
    }

    /**
     * 最大子序和-贪心
     * 如果前 i 个元素的子序列和小于 0，则丢弃
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        int preSum = 0;

        for (int i = 1; i < nums.length; i++) {
            preSum = curSum;
            if (preSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }

            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    /**
     * 最大子序和-贪心
     * 官方题解-优雅
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        int preSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);

            maxSum = Math.max(maxSum, preSum);
        }

        return maxSum;
    }

    /**
     * 最大子序和-动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }

        Arrays.sort(nums);

        return nums[nums.length - 1];
    }
}
