package codingInterviewDay_2.day14;

import java.util.Deque;
import java.util.LinkedList;

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
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {0, 0});
        visited[0][0] = true;
        int[][] direction = new int[][] {{0, 1}, {1, 0}};  // right, down
        int ans = 1;

        while (!deque.isEmpty()) {
            int[] cur = deque.remove();
            for (int i = 0; i < direction.length; i++) {
                int nx = direction[i][0] + cur[0];  // next x
                int ny = direction[i][1] + cur[1];  // next y
                if (nx < 0 || nx >= m || ny < 0 || ny > n || visited[nx][ny] || get(nx) + get(ny) > k) {
                    continue;
                }
                deque.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int pos) {
        int sum = 0;
        while (pos != 0) {
            sum += pos % 10;
            pos /= 10;
        }
        return sum;
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
        if (!(i < 0 || i >= m || j < 0 || j >= n || visited[i * m + j] || get(i) + get(j) > k)) {
            visited[i * m + j] = true;
            cnt = 1 + dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited);
        }
        return cnt;
    }
}
