package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.02. 迷路的机器人
 * @author xinchan
 * @version 1.0.1 2022-09-14
 */
public class Solution02 {
    private List<List<Integer>> ans;
    private boolean[][] visited;
    private int[][] obstacleGrid;
    private int r;
    private int c;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.ans = new ArrayList<>();
        this.r = obstacleGrid.length;
        this.c = obstacleGrid[0].length;
        this.visited = new boolean[r][c];
        this.obstacleGrid = obstacleGrid;
        dfs(0, 0);

        return ans;
    }

    private boolean dfs(int row, int column) {
        if (row >= r || column >= c || obstacleGrid[row][column] == 1 || visited[row][column]) {
            return false;
        }
        ans.add(Arrays.asList(row, column));
        visited[row][column] = true;
        if (row == r - 1 && column == c - 1) {
            return true;
        }
        if (dfs(row, column + 1) || dfs(row + 1, column)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }
}
