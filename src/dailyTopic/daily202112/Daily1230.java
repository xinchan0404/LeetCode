package dailyTopic.daily202112;

import java.util.*;

/**
 * 846. 一手顺子
 * 提示：
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *
 * @author xinchan
 * @version 1.0.1 2021-12-30
 */
public class Daily1230 {
    public static void main(String[] args) {
        /*
         * 测试 isNStraightHand()
         */
        Daily1230 daily1230 = new Daily1230();
        int[] head = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        boolean isNStraightHand = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isNStraightHand = daily1230.isNStraightHand(head, groupSize);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isNStraightHand);
    }

    /**
     * 一手顺子
     *
     * @param head
     * @param groupSize
     * @return
     */
    public boolean isNStraightHand(int[] head, int groupSize) {
        int n = head.length;
        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : head) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        Arrays.sort(head);
        for (int e : head) {
            if (map.getOrDefault(e, 0) > 0) {
                map.put(e, map.get(e) - 1);
                for (int i = 1; i < groupSize; i++) {
                    if (map.getOrDefault(e + i, 0) > 0) {
                        map.put(e + i, map.get(e + i) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
