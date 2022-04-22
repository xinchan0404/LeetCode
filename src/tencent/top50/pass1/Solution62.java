package tencent.top50.pass1;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-22
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] cnt = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cnt[i][j] = 1;
                } else {
                    cnt[i][j] = cnt[i - 1][j] + cnt[i][j - 1];
                }
            }
        }
        return cnt[m - 1][n - 1];
    }
}
