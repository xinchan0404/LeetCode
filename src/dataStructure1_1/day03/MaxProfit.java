package dataStructure1_1.day03;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class MaxProfit {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {7, 3, 5, 10, 1, 4, 6};
//        int[] prices = {1, 0};
//        int[] prices = {1};
        int[] prices = {1, 2, 3, 4, 5};
        int maxProfit = 0;

        maxProfit = maxProfit(prices);

        System.out.println("最大利润：" + maxProfit);
    }

    /**
     * 121. 买卖股票的最佳时机-贪心
     * 如果当前股价低于之前股价，则按当前股价买入，如果当前股价高于买入股价，计算此时卖出股票的利润
     * 提示：
     * 1. 1 <= prices.length <= 105
     * 2. 0 <= prices[i] <= 104
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }
}
