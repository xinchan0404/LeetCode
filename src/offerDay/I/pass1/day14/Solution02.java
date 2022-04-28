package offerDay.I.pass1.day14;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution02 {
    /**
     * 剑指 Offer 13. 机器人的运动范围 - BFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[] visited = new boolean[m * n];
        int[][] direction = new int[][] {{1, 0}, {0, 1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {0, 0});
        visited[0] = true;
        int cnt = 1;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int i = 0; i < 2; i++) {
                int nx = cur[0] + direction[i][0];
                int ny = cur[1] + direction[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx * n + ny] || getSum(nx) + getSum(ny) > k) {
                    continue;
                }
                deque.offer(new int[] {nx, ny});
                visited[nx * n + ny] = true;
                cnt++;
            }
        }
        return cnt;
    }

    private int getSum(int coordinate) {
        int ans = 0;
        while (coordinate > 0) {
            ans += coordinate % 10;
            coordinate /= 10;
        }
        return ans;
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围 - DFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[] visited = new boolean[m * n];
        return dfs(m, n, 0, 0, k, visited);
    }

    private int dfs(int m, int n, int i, int j, int k, boolean[] visited) {
        int cnt = 0;
        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i * n + j] && getSum(i) + getSum(j) <= k) {
            visited[i * n + j] = true;
            cnt = 1 + dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited);
        }
        return cnt;
    }
}
