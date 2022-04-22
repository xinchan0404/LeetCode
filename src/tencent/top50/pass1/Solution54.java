package tencent.top50.pass1;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int cnt = 0;
        int total = m * n;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[total];
        int x = 0;
        int y = 0;
        while (cnt < total) {
            list.add(matrix[x][y]);
            visited[x * n + y] = true;
            cnt++;
            int nx = x + direction[dir][0];
            int ny = y + direction[dir][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx * n + ny]) {
                dir = (dir + 1) % 4;
                x += direction[dir][0];
                y += direction[dir][1];
            } else {
                x = nx;
                y = ny;
            }
        }
        return list;
    }
}
