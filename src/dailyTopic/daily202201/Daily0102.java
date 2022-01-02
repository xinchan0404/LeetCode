package dailyTopic.daily202201;

import java.util.LinkedList;
import java.util.List;

public class Daily0102 {
    public static void main(String[] args) {
        /*
         * 测试 lastRemaining()
         */
        // Daily0102 daily0102 = new Daily0102();
        Daily0102 daily0102 = new Daily0102();
        int n = 12;
        int remaining = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            // remaining = daily0102.lastRemaining(n);
            remaining = daily0102.lastRemaining1(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(remaining);
    }

    /**
     * 消除游戏 - 超时
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        boolean head = true;
        while (list.size() != 1) {
            int size = list.size();
            if (head) {
                for (int i = 0; i < size / 2 + size % 2; i++) {
                    list.remove(i);
                }
                head = false;
            } else {
                int start = size % 2 == 0? 1 : 0;
                for (int i = start; i < start + size / 2 + size % 2; i++) {
                    list.remove(i);
                }
                head = true;
            }
        }

        return list.get(0);
    }

    
    /**
     * 消除游戏 - 数学模拟
     * @param n
     * @return
     */
    public int lastRemaining1(int n) {
        int size = n;
        boolean head = true;
        int left = 1;
        int right = n;
        int i = 0;

        while (size != 1) {
            int d = (int) Math.pow(2, i);
            if (head) {
                left = (int) (left + d);
                if (size % 2 != 0) {
                    right = (int) (right - d);
                }
            } else {
                right = (int)(right - d);
                if (size % 2 != 0) {
                    left = (int) (left + d);
                }
            }
            head = !head;
            size /= 2;
            i++;
        }

        return left;
    }
}
