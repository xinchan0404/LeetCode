package codingInterviewDay_2.day05;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution01 {
    /**
     * 剑指 Offer 04. 二维数组中的查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }
}
