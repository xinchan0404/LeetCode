package leetCode.queueAndStack.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. 岛屿数量
 * @author xinchan
 * @version 1.0.1 2022-02-12
 */
public class Solution01 {
    private int rows;
    private int columns;
    /**
     * DFS、递归
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        this.rows = grid.length;
        this.columns = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 迭代、BFS
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        Deque<int[]> deque = new ArrayDeque<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    grid[i][j] = '0';
                    deque.add(new int[] {i, j});
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        for (int k = 0; k < size; k++) {
                            int[] los = deque.remove();
                            int r = los[0];
                            int c = los[1];
                            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                                deque.add(new int[] {r - 1, c});
                                grid[r - 1][c] = '0';
                            }
                            if (r + 1 <= rows - 1 && grid[r + 1][c] == '1') {
                                deque.add(new int[] {r + 1, c});
                                grid[r + 1][c] = '0';
                            }
                            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                                deque.add(new int[] {r, c - 1});
                                grid[r][c - 1] = '0';
                            }
                            if (c + 1 <= columns - 1 && grid[r][c + 1] == '1') {
                                deque.add(new int[] {r, c + 1});
                                grid[r][c + 1] = '0';
                            }
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
