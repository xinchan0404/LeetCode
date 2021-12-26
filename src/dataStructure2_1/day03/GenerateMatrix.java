package dataStructure2_1.day03;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 提示：
 * 1 <= n <= 20
 *
 * @author xinchan
 * @version 1.0.1 2021-12-26
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        /*
         * 测试 generateMatrix()
         */
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int n = 3;
        int[][] matrix = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            matrix = generateMatrix.generateMatrix(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 螺旋矩阵 II -
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cur = 1;
        int i = 0;
        int j = 0;

        while (cur < n * n) {
            if (j < n) {
                matrix[i][j++] = cur++;
            } else if (i < n) {
                matrix[i++][j] = cur++;
            } else if (j > 0) {
                matrix[i - 1][--j - 1] = cur++;
            }
        }

        return matrix;
    }
}
