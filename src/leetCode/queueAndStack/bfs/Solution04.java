package leetCode.queueAndStack.bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 279. 完全平方数
 * @author xinchan
 * @version 1.0.1 2022-02-14
 */
public class Solution04 {
    /**
     * BFS：起点为 1，终点为 n，只能在完全平方数集中取数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        double nSqrt = Math.sqrt(n);
        if (n == Math.pow(nSqrt, 2)) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < (int) nSqrt; i++) {
            set.add(i);
        }

        return -1;
    }
}
