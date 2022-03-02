package codingInterviewDay_2.day09;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution02 {
    /**
     * 剑指 Offer 47. 礼物的最大价值 - 动态规划，dp[m][n]
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
