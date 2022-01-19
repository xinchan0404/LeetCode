package crackingTheCodingInterview.ch01;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution07 {
    /**
     * 面试题 01.07. 旋转矩阵 -
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            solution07.rotate(matrix);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(Arrays.deepToString(matrix));
    }
}
