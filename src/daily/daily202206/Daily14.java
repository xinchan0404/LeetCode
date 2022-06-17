package daily.daily202206;

/**
 * 498. 对角线遍历
 * @author xinchan
 * @version 1.0.1 2022-06-15
 */
public class Daily14 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean flag = false;
        int[] ans = new int[m * n];
        boolean[] visited = new boolean[m * n];
        int idx = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (idx % 2 == 0) {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - (m - 1);
                while ()
            } else {

            }
            idx++;
        }
        while (row <= m - 1 || column <= n - 1) {
            if (!flag) {
                while (row >= 0 && row <= m - 1 && column >= 0 && column <= n - 1) {
                    ans[idx++] = mat[row--][column++];
                }
                while (row )
            } else {
                while (row >= 0 && row <= m - 1 && column >= 0 && column <= n - 1) {
                    ans[idx++] = mat[row++][column--];
                }
                if (column < n - 1) {
                    column++;
                } else {
                    row--;
                }
            }
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {
        Daily14 daily14 = new Daily14();
        int[][] mat = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] ans = daily14.findDiagonalOrder(mat);
    }
}
