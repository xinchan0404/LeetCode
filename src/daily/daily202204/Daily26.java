package daily.daily202204;

/**
 * 883. 三维形体投影面积
 * @author xinchan
 * @version 1.0.1 2022-04-26
 */
public class Daily26 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0;
        int xz = 0;
        int yz = 0;
        for (int i = 0; i < n; i++) {
            int xzm = Integer.MIN_VALUE;
            int yzm = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                xy += grid[i][j] != 0 ? 1 : 0;
                xzm = Math.max(xzm, grid[i][j]);
                yzm = Math.max(yzm, grid[j][i]);
            }
            xz += xzm;
            yz += yzm;
        }
        return xy + xz + yz;
    }
}
