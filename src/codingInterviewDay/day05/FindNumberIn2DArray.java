package codingInterviewDay.day05;

import java.util.Arrays;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 
 * @author xinchan
 * @version 1.0.1
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        /*
         * 测试 findNumberIn2DArray()
         */
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        // int[][] matrix = {
        //         { 1, 4, 7, 11, 15 },
        //         { 2, 5, 8, 12, 19 },
        //         { 3, 6, 9, 16, 22 },
        //         { 10, 13, 14, 17, 24 },
        //         { 18, 21, 23, 26, 30 }};
        int[][] matrix = {};
        int target = 31;
        boolean exist = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            exist = findNumberIn2DArray.findNumberIn2DArray(matrix, target);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(exist);
    }

    /**
     * 二维数组中的查找 - 一维数组的二分查找
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(matrix[i], target);
            if (pos >= 0 && pos <= m - 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * 二维数组中的查找 - 缩小查找范围
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        
        return false;
    }
}
