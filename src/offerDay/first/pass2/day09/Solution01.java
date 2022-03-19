package offerDay.first.pass2.day09;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution01 {
    /**
     * 剑指 Offer 42. 连续子数组的最大和 - 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
