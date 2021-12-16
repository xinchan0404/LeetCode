package dataStructure1_2.day05;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * @author xinchan
 * @version 1.0.1 2021-12-15
 */
public class SetZeroes {
    public static void main(String[] args) {
        /*
         * 测试 setZeroes()
         */
        SetZeroes setZeroes = new SetZeroes();

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes.setZeroes1(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 矩阵置零 - O(m + n) 额外空间
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] column = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 矩阵置零 - O(1)
     *
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        int m = matrix.length;
        int n = matrix[0].length;

        /*
         * 第一行是否包含 0
         */
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        /*
         * 第一列是否包含 0
         */
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            matrix[0] = new int[n];
        }
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
