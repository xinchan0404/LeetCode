package tencent.top50.pass1;

/**
 * 122. 买卖股票的最佳时机 II
 * @author xinchan
 * @version 1.0.1 2022-04-26
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int total = 0;
        for (int i = 1; i < n; i++) {
            total += Math.max(0, prices[i] - prices[i - 1]);
        }
        return total;
    }
}

class Solution122_ {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;  // 第 0 天没有持有股票的收益
        int dp1 = -prices[0];  // 第 0 天持有股票的收益
        int dpi0;
        int dpi1;
        for (int i = 1; i < n; i++) {
            dpi0 = Math.max(dp0, dp1 + prices[i]);
            dpi1 = Math.max(dp0 - prices[i], dp1);
            dp0 = dpi0;
            dp1 = dpi1;
        }
        return Math.max(dp0, dp1);
    }
}
