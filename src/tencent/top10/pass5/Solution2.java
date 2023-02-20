package tencent.top10.pass5;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
