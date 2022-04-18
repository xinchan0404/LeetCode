package tencent.top50;

/**
 * 59. 螺旋矩阵 II
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int total = n * n;
        int x = 0;
        int y = 0;
        int cnt = 1;
        for (int i = 0; i < total; i++) {
            matrix[x][y] = cnt;
            int nx = x + directions[index][0];
            int ny = y + directions[index][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != 0) {
                index = (index + 1) % 4;
                x += directions[index][0];
                y += directions[index][1];
            } else {
                x = nx;
                y = ny;
            }
            cnt++;
        }
        return matrix;
    }
}
