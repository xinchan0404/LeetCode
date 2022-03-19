package datastructure.second.pass1.day03;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * 提示：
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-26
 */
public class Rotate {
    public static void main(String[] args) {
        /*
         * 测试 rotate()
         */
        Rotate rotate = new Rotate();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            rotate.rotate(matrix);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 旋转图像 - 原地旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[n- j - 1][i];
                matrix[n- j - 1][i] = tmp;
            }
        }
    }
}
