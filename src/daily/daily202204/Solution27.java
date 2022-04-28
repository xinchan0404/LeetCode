package daily.daily202204;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Solution27 {
    private int[][] dirs;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);  // up
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);  // left
        }
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, atlantic);  // down
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);  // right
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    ans.add(pos);
                }
            }
        }

        return ans;
    }

    /**
     * 沿着某个方向不断前进，直至无法前进再调换方向
     * @param x
     * @param y
     * @param ocean
     */
    private void dfs(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && heights[nx][ny] >= heights[x][y]) {
                dfs(nx, ny, ocean);
            }
        }
    }
}

class Solution27_ {
    private int[][] dirs;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bfs(0, i, pacific);  // up
        }
        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);  // left
        }
        for (int i = 0; i < n; i++) {
            bfs(m - 1, i, atlantic);  // down
        }
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }

        return lists;
    }

    /**
     * 每次环绕四个方向前进，直至某个点的四个方向均无法前进，再迭代下一个方向的四个方向
     * @param x
     * @param y
     * @param ocean
     */
    private void bfs(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {x, y});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && heights[nx][ny] >= heights[cur[0]][cur[1]] && !ocean[nx][ny]) {
                    ocean[nx][ny] = true;
                    deque.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
