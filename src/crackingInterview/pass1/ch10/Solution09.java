package crackingInterview.pass1.ch10;

/**
 * 面试题 10.09. 排序矩阵查找
 * @author xinchan
 * @version 1.0.1 2022-09-22
 */
public class Solution09 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, i = 0, j = matrix[0].length;
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}

class Solution09_ {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            if (search(ints, 0, n - 1, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
