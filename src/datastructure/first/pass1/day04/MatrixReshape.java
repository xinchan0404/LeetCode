package datastructure.first.pass1.day04;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * 提示：
 * 1. m == mat.length
 * 2. n == mat[i].length
 * 3. 1 <= m, n <= 100
 * 4. -1000 <= mat[i][j] <= 1000
 * 5. 1 <= r, c <= 300
 *
 * @author xinchan
 * @version 1.0.1 2021-11-28
 */
public class MatrixReshape {
    public static void main(String[] args) {
//        int[][] mat = {{1,2}, {3,4}};
//        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] mat = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}};
        int r = 2;
        int c = 6;

//        int[][] reshapeMatrix = matrixReshape(mat, r, c);
        int[][] reshapeMatrix = matrixReshape1(mat, r, c);

        show(reshapeMatrix);
    }

    /**
     * 重塑矩阵 - 二维数组一维化
     * 想到了第一层，但是没有想到一维数组的二维化
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length;
        int matCol = mat[0].length;
        if (matRow * matCol != r * c) {
            return mat;
        }

        int[] total = new int[matRow * matCol];
        for (int i = 0; i < matRow; i++) {
            for (int j = 0; j < matCol; j++) {
                total[i * matCol + j] = mat[i][j];
            }
        }

        int[][] reshapeMatrix = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeMatrix[i][j] = total[k++];
            }
        }

        return reshapeMatrix;
    }

    /**
     * 重塑矩阵 - 一维数组与二维数组转换
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape1(int[][] mat, int r, int c) {
        int matRow = mat.length;
        int matCol = mat[0].length;
        if (matRow * matCol != r * c) {
            return mat;
        }

        int[][] reshapeMatrix = new int[r][c];
        for (int k = 0; k < matRow * matCol; k++) {
            int i = k / matCol;
            int j = k % matCol;
            int rIndex = k / c;
            int cIndex = k % c;
            reshapeMatrix[rIndex][cIndex] = mat[i][j];
//            reshapeMatrix[k / c][k % c] = mat[k / matCol][k % matCol];  // 速度更快一点
        }

        return reshapeMatrix;
    }

    /**
     * 打印矩阵
     *
     * @param mat
     */
    public static void show(int[][] mat) {
        System.out.println(Arrays.deepToString(mat));
    }
}
