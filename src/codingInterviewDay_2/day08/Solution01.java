package codingInterviewDay_2.day08;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution01 {
    /**
     * 剑指 Offer 10- I. 斐波那契数列 - dp[n + 1]
     * @param n
     * @return
     */
    public int fib(int n) {
        final int mod = 1000000007;
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] + dp[i - 2] > mod) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * 动态规划 + 滚动数组
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        final int MOD = 1000000007;
        int first = 0;
        int second = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if (first + second >= MOD) {
                sum = (first + second) % MOD;
            } else {
                sum = first + second;
            }
            first = second;
            second = sum;
        }
        return sum;
    }
}
