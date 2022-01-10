package daily.daily202112;

/**
 * 807. 保持城市天际线
 * 说明:
 * 1 < grid.length = grid[0].length <= 50。
 * grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 *
 * @author xinchan
 * @version 1.0.1 2021-12-13
 */
public class Daily1213 {
    public static void main(String[] args) {
        /*
         * 测试 maxIncreaseKeepingSkyline()
         */
        Daily1213 daily1213 = new Daily1213();

        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
//        int[][] grid = {{10}};

        int maxSum = daily1213.maxIncreaseKeepingSkyline2(grid);

        System.out.println(maxSum);
    }

    /**
     * 保持城市天际线 - 获取各行各列最大值
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline1(int[][] grid) {
        int gridLength = grid.length;
        int[] rowMax = new int[gridLength];
        int[] columnMax = new int[gridLength];

        for (int i = 0; i < gridLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < gridLength; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            rowMax[i] = max;
        }

        for (int i = 0; i < gridLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < gridLength; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            columnMax[i] = max;
        }

        int maxSum = 0;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                maxSum += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }

        return maxSum;
    }

    /**
     * 保持城市天际线 - 获取各行各列最大值
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline2(int[][] grid) {
        int gridLength = grid.length;
        int[] rowMax = new int[gridLength];
        int[] columnMax = new int[gridLength];

        for (int i = 0; i < gridLength; i++) {
            int maxRow = Integer.MIN_VALUE;
            int maxColumn = Integer.MIN_VALUE;
            for (int j = 0; j < gridLength; j++) {
                if (maxRow < grid[i][j]) {
                    maxRow = grid[i][j];
                }
                if (maxColumn < grid[j][i]) {
                    maxColumn = grid[j][i];
                }
            }
            rowMax[i] = maxRow;
            columnMax[i] = maxColumn;
        }

        int maxSum = 0;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                maxSum += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }

        return maxSum;
    }
}
