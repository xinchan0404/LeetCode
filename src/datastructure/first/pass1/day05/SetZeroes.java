package datastructure.first.pass1.day05;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 提示：
 * 1. m == matrix.length
 * 2. n == matrix[0].length
 * 3. 1 <= m, n <= 200
 * 4. -231 <= matrix[i][j] <= 231 - 1
 *
 * @author xinchan
 * @version 1.0.1 2021-11-29
 */
public class SetZeroes {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        setZeroes1(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 矩阵置零 - O(m + n)
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
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
     * 矩阵置零 - O(1)、使用两个标志位
     *
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {
        boolean row_first = false;
        boolean column_first = false;
        int row = matrix.length;
        int column = matrix[0].length;

        /*
         * 记录第一行和第一列是否有零，必须将第一行和第一列单独提出来，因为存储数组的变化会影响到后续的判断，所以必须要单独提出放置到最后处理
         */
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == 0) {
                row_first = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                column_first = true;
                break;
            }
        }

        /*
         * 使用第一行和第一列记录每一行每一列（除第一行和第一列外）是否有 0
         */
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row_first) {
            matrix[0] = new int[column];
        }

        if (column_first) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
