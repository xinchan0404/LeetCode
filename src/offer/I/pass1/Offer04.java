package offer.I.pass1;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < n && j >= 0) {
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
