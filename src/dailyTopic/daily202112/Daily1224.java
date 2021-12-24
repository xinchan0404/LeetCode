package dailyTopic.daily202112;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * 提示：
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 *
 * @author xinchan
 * @version 1.0.1 2021-12-24
 */
public class Daily1224 {
    public static void main(String[] args) {
        /*
         * 测试 eatenApples()
         */
        Daily1224 daily1224 = new Daily1224();
//        int[] apples = {1, 2, 3, 5, 2};
//        int[] days = {3, 2, 1, 4, 2};
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};
        int eatenApples = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            eatenApples = daily1224.eatenApples(apples, days);  // 1000000: 100 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(eatenApples);
    }

    /**
     * 吃苹果的最大数目 - 贪心、优先队列
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int eatenApples = 0;
        int n = apples.length;
        int i = 0;
        while (i < n || !priorityQueue.isEmpty()) {
            while (!priorityQueue.isEmpty() && priorityQueue.element()[0] <= i) {
                priorityQueue.remove();
            }

            if (i < n && apples[i] > 0) {
                priorityQueue.add(new int[]{i + days[i], apples[i]});
            }

            if (!priorityQueue.isEmpty()) {
                int[] head = priorityQueue.element();
                head[1]--;
                if (head[1] == 0) {
                    priorityQueue.remove();
                }
                eatenApples++;
            }
            i++;
        }

        return eatenApples;
    }
}
