package offerDay.first.pass2.day08;

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
}
