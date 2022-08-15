package tencent.top10.pass3;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * @author xinchan
 * @version 1.0.1 2022-08-01
 */
public class Solution02 {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int n = nums.length;
        // 以当前元素结尾的最大长度，注意：必须以当前元素结尾
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
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
