package dailyTopic;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class Daily1220 {
    public static void main(String[] args) {
        /*
         * 测试 findRadius()
         */
        Daily1220 daily1220 = new Daily1220();
        int[] houses = {1, 2, 3, 4, 5, 6};
        int[] heaters = {2, 4};
        int radius = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            radius = daily1220.findRadius(houses, heaters);  // 1000000: 46 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(radius);
    }

    /**
     * 供暖器 - 排序、二分查找
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int housesLength = houses.length;
        int heatersLength = heaters.length;
        int[] housesRadius = new int[housesLength];
        for (int i = 0; i < housesLength; i++) {
            int minR = Integer.MAX_VALUE;
            for (int j = 0; j < heatersLength; j++) {
                if (houses[i] == heaters[j]) {
                    minR = 0;
                    break;
                }
                int curRadius = Math.abs(houses[i] - heaters[j]);
                if (minR > curRadius) {
                    minR = curRadius;
                }
            }
            housesRadius[i] = minR;
        }

        int radius = Integer.MIN_VALUE;
        for (int r : housesRadius) {
            if (radius < r) {
                radius = r;
            }
        }

        return radius;
    }
}
