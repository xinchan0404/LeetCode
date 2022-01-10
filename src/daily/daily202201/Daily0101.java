package daily.daily202201;

import java.util.Arrays;

/**
 * 2022. 将一维数组转变成二维数组 - 2022 奋进
 * 提示：
 * 1 <= original.length <= 5 * 10^4
 * 1 <= original[i] <= 10^5
 * 1 <= m, n <= 4 * 104
 *
 * @author xinchan
 * @version 1.0.1 2022-01-01
 */
public class Daily0101 {
    public static void main(String[] args) {
        /*
         * 测试 construct2DArray()
         */
        Daily0101 daily0101 = new Daily0101();
//        int[] original = {1, 2, 3, 4};
//        int m = 2;
//        int n = 2;
//        int[] original = {1, 2, 3, 4};
//        int m = 1;
//        int n = 4;
        int[] original = {};
        int m = 1;
        int n = 4;
        int[][] matrix = new int[m][n];
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            matrix = daily0101.construct2DArray(original, m, n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 将一维数组转变成二维数组
     *
     * @param original
     * @param m
     * @param m
     * @return
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][];
        }

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }

        return matrix;
    }
}
