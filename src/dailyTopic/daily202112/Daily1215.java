package dailyTopic.daily202112;

import java.util.*;

/**
 * 851. 喧闹和富有
 * 提示：
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值 互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对 互不相同
 * 对 richer 的观察在逻辑上是一致的
 *
 * @author xinchan
 * @version 1.0.1 2021-12-15
 */
public class Daily1215 {
    public static void main(String[] args) {
        /*
         * 测试 loudAndRich()
         */
        Daily1215 daily1215 = new Daily1215();

//        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
//        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
//        int[][] richer = {};
//        int[] quiet = {0};
//        int[][] richer = {{0, 1}, {1, 2}};
//        int[] quiet = {0, 1, 2};
        int[][] richer = {{0, 1}, {0, 6}, {0, 8}, {0, 12}, {0, 17}, {1, 5}, {1, 9}, {1, 12}, {1, 19}, {2, 4}, {2, 5},
                {2, 14}, {2, 16}, {3, 7}, {3, 15}, {4, 11}, {4, 12}, {4, 14}, {4, 16}, {4, 18}, {5, 6},
                {5, 13}, {5, 17}, {5, 18}, {5, 19}, {6, 12}, {6, 13}, {8, 10}, {8, 11}, {8, 14}, {8, 18},
                {9, 11}, {9, 15}, {11, 14}, {12, 16}, {13, 14}, {13, 15}, {14, 18}, {15, 18}, {16, 18},
                {16, 19}, {17, 19}};
        int[] quiet = {9, 1, 12, 0, 13, 15, 14, 7, 8, 19, 5, 16, 3, 4, 11, 10, 2, 17, 6, 18};
        int[] answer = new int[0];

        answer = daily1215.loudAndRich(richer, quiet);

        System.out.println(Arrays.toString(answer));
    }

    /**
     * 喧闹和富有 - 记录所有比某个人富有的人，再从中找出安静值最小的人
     *
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            Deque<Integer> deque = new LinkedList<>();
            set.add(i);
            deque.add(i);
            while (!deque.isEmpty()) {
                for (int[] ints : richer) {
                    if (ints[1] == deque.element()) {
                        set.add(ints[0]);
                        deque.add(ints[0]);
                    }
                }
                deque.remove();
            }

            int minQuiet = quiet[i];
            int minIndex = i;
            for (int j : set) {
                if (minQuiet > quiet[j]) {
                    minQuiet = quiet[j];
                    minIndex = j;
                }
            }
            answer[i] = minIndex;
        }

        return answer;
    }
}
