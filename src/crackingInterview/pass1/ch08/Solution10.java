package crackingInterview.pass1.ch08;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 08.10. 颜色填充
 * @author xinchan
 * @version 1.0.1 2022-09-19
 */
public class Solution10 {
    private int newColor;
    private int rawColor;
    private int m;
    private int n;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.newColor = newColor;
        this.rawColor = image[sr][sc];
        this.m = image.length;
        this.n = image[0].length;

        if (newColor != rawColor) {
            dfs(image, sr, sc);
        }

        return image;
    }

    private void dfs(int[][] image, int row, int column) {
        if (image[row][column] == rawColor) {
            image[row][column] = newColor;
            for (int i = 0; i < 4; i++) {
                int nr = row + dirs[i][0];
                int nc = column + dirs[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    dfs(image, nr, nc);
                }
            }
        }
    }
}

class Solution10_ {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rawColor = image[sr][sc];
        if (rawColor == newColor) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {sr, sc});
        image[sr][sc] = newColor;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dirs[i][0];
                int nc = cur[1] + dirs[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nr < n || image[nr][nc] == rawColor) {
                    deque.offer(new int[] {nr, nc});
                    image[nr][nc] = newColor;
                }
            }
        }

        return image;
    }
}
