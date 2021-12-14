package dataStructure1_2.day03;

/**
 * 121. 买卖股票的最佳时机
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @author xinchan
 * @version 1.0.1 2021-12-14
 */
public class MaxProfit {
    public static void main(String[] args) {
        /*
         * 测试 maxProfit()
         */
        MaxProfit maxProfit = new MaxProfit();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int profit = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            profit = maxProfit.maxProfit(prices);
        }
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + timeCost + " ms");

        System.out.println(profit);
    }

    /**
     * 买股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy_price = Integer.MAX_VALUE;

        for (int price : prices) {
            if (buy_price > price) {
                buy_price = price;
            }
            maxProfit = Math.max(maxProfit, price - buy_price);
        }

        return maxProfit;
    }
}
