package daily.daily202112;

/**
 * 1518. 换酒问题
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-17
 */
public class Daily1217 {
    public static void main(String[] args) {
        /*
         * 测试 numWaterBottles()
         */
        Daily1217 daily1217 = new Daily1217();

//        int numBottles = 9;
//        int numExchange = 3;
        int numBottles = 15;
        int numExchange = 4;
        int maxBottles = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            maxBottles = daily1217.numWaterBottles(numBottles, numExchange);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(maxBottles);
    }

    /**
     * 换就问题
     *
     * @param numBottles
     * @param numExchange
     * @return
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxBottles = numBottles;
        while (numBottles >= numExchange) {
            maxBottles += numBottles / numExchange;
            numBottles = numBottles % numExchange + numBottles / numExchange;
        }

        return maxBottles;
    }
}
