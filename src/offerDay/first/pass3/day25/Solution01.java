package offerDay.first.pass3.day25;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * @author xinchan
 * @version 1.0.1 2022-03-24
 */
public class Solution01 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        boolean[] visited = new boolean[total];
        int[] cur = {0, 0};
        int[] ans = new int[total];
        for (int i = 0; i < total; i++) {
            visited[cur[0] * n + cur[1]] = true;
            ans[i] = matrix[cur[0]][cur[1]];
            int[] next = {cur[0] + directions[directionIndex][0], cur[1] + directions[directionIndex][1]};
            if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n || visited[next[0] * n + next[1]]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            cur[0] += directions[directionIndex][0];
            cur[1] += directions[directionIndex][1];
        }
        return ans;
    }
}
