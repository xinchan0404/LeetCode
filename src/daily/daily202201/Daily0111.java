package daily.daily202201;

import java.util.*;

/**
 * 1036. 逃离大迷宫
 *
 * @author xinchan
 * @version 1.0.1 2022-01-11
 */
public class Daily0111 {
    /**
     * 逃离大迷宫 -
     *
     * @param blocked
     * @param source
     * @param target
     * @return
     */
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<int[]> blockedSet = new HashSet<>(Arrays.asList(blocked));

        Deque<int[]> stack = new ArrayDeque<>();
        int[] cur = new int[]{source[0], source[1]};
        int i = source[0];
        int j = source[1];

        return false;
    }

    public static void main(String[] args) {
        Daily0111 daily0111 = new Daily0111();
        int[][] blocked = {{}};
        int[] source = {0, 0};
        int[] target = {999999, 999999};
        boolean isEscapePossible = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            isEscapePossible = daily0111.isEscapePossible(blocked, source, target);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isEscapePossible);
    }
}
