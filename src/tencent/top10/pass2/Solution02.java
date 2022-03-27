package tencent.top10.pass2;

/**
 * 300. 最长递增子序列
 * @author xinchan
 * @version 1.0.1 2022-03-27
 */
public class Solution02 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
