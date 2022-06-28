package offerDay.I.pass1.day05;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author xinchan
 * @version 1.0.1 2022-￥06-28
 */
public class Solution01 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j > -1) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
