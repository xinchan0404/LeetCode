package codingInterviewDay_2.day08;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution03 {
    /**
     * 剑指 Offer 63. 股票的最大利润 - 贪心
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n < 2) {
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < n; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }

        return maxProfit;
    }

    /**
     * 剑指 Offer 63. 股票的最大利润 - 动态规划
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - buyPrice);
        }

        return dp[n - 1];
    }
}
