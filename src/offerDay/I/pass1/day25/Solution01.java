package offerDay.I.pass1.day25;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-11
 */
public class Solution01 {
    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] visited = new boolean[m * n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 从左到右，从上到下，从右到左，从下到上
        int directionsIndex = 0;
        int total = m * n;
        int[] ans = new int[total];
        int row = 0;
        int column = 0;
        int k = 0;
        for (int i = 0; i < total; i++) {
            visited[row * n + column] = true;
            ans[k++] = matrix[row][column];
            int nextRow = row + directions[directionsIndex][0];
            int nextColumn = column + directions[directionsIndex][1];
            if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || visited[nextRow * n + nextColumn]) {
                directionsIndex = (directionsIndex + 1) % 4;
            }
            row += directions[directionsIndex][0];
            column += directions[directionsIndex][1];
        }
        return ans;
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵 - 按层模拟
     * @param matrix
     * @return
     */
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int[] ans = new int[total];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int index = 0;
        while (index < total) {
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans[index++] = matrix[bottom][i];
                }
                for (int i = bottom - 1; i >= top - 1; i--) {
                    ans[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return ans;
    }
}
