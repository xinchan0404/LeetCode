package datastructure.first.pass2.day04;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * @author xinchan
 * @version 1.0.1 2021-12-14
 */
public class MatrixReshape {
    public static void main(String[] args) {
        /*
         * 测试 matrixReshape()
         */
        MatrixReshape matrixReshape = new MatrixReshape();

        int[][] mat = {{1,2}, {3,4}};
        int r = 1;
        int c = 4;

        int[][] matReshape = new int[0][0];

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            matReshape = matrixReshape.matrixReshape(mat, r, c);  // 1000000 次：113 ms
            matReshape = matrixReshape.matrixReshape1(mat, r, c);  // 1000000 次：105 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + "ms");

        System.out.println(Arrays.deepToString(matReshape));
    }

    /**
     * 重塑矩阵 - 一维数组与二维数组之间的转换
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[] array = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, array, i * n, n);
        }

        int[][] matReshape = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(array, i * c, matReshape[i], 0, c);
        }

        return matReshape;
    }

    /**
     * 重塑矩阵 - 官方题解
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] matReshape = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            matReshape[i / c][i % c] = mat[i / n][i % n];
        }

        return matReshape;
    }
}
