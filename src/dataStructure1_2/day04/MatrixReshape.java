package dataStructure1_2.day04;

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

    }

    /**
     * 重塑矩阵
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


    }
}
