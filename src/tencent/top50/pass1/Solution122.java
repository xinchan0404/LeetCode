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
        int profit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < buyPrice && buyPrice != 0) {
                buyPrice = prices[i];
            } else {
                profit = prices[i] - buyPrice;
            }
        }
    }
}
