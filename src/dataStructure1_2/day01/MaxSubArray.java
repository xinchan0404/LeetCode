package dataStructure1_2.day01;

/**
 * 53. 最大子数组和
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author xinchan
 * @version 1.0.1 2021-12-11
 */
public class MaxSubArray {
    public static void main(String[] args) {
        /*
         * 测试 maxSubArray()
         */
        MaxSubArray maxSubArray = new MaxSubArray();

//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
        int[] nums = {-2, -3, -4, -5};
        int maxSum = maxSubArray.maxSubArray1(nums);
        System.out.println(maxSum);
    }

    /**
     * 最大子数组和 - 贪心算法，如果当前指针所指元素之前的和小于 0，则丢弃当前元素之前的序列
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int preSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (preSum < 0) {
                preSum = num;
            } else {
                preSum += num;
            }
//            preSum = Math.max(num, preSum + num);
            maxSum = Math.max(maxSum, preSum);
        }

        return maxSum;
    }

    /**
     * 最大子数组和 - 动态规划，如果前一个元素大于 0，则将其加到当前元素上
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                nums[i + 1] += nums[i];
            }
            if (maxSum < nums[i + 1]) {
                maxSum = nums[i + 1];
            }
        }

        return maxSum;
    }
}
