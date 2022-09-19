package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 *
 * @author xinchan
 * @version 1.0.1 2022-09-19
 */
public class Solution12 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];

        Arrays.fill(queens, -1);
        dfs(ans, queens, n, 0);

        return ans;
    }

    private void dfs(List<List<String>> ans, int[] queens, int n, int rows) {
        if (rows == n) {
            List<String> list = generateBoard(queens, n);
            ans.add(new ArrayList<>(list));
        }
        for (int i = 0; i < n; i++) {
            if (isValid(queens, rows, i)) {
                queens[rows] = i;
                dfs(ans, queens, n, rows + 1);
                queens[rows] = -1;
            }
        }
    }

    private boolean isValid(int[] queens, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == column || queens[i] + row - i == column || queens[i] - row + i == column) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            list.add(new String(chars));
        }
        return list;
    }
}

class Solution12_ {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];

        Arrays.fill(queens, -1);
        dfs(ans, queens, n, 0);

        return ans;
    }

    private void dfs(List<List<String>> ans, int[] queens, int n, int rows) {
        if (rows == n) {
            List<String> list = generateBoard(queens, n);
            ans.add(new ArrayList<>(list));
        }

        boolean[] isValid = isValid(queens, n, rows);
        for (int i = 0; i < n; i++) {
            if (isValid[i]) {
                queens[rows] = i;
                dfs(ans, queens, n, rows + 1);
                queens[rows] = -1;
            }
        }
    }

    private boolean[] isValid(int[] queens, int n, int row) {
        boolean[] isValid = new boolean[n];
        Arrays.fill(isValid, true);
        for (int i = 0; i < row; i++) {
            for (int j : new int[] {queens[i], queens[i] + row - i, queens[i] - row + i}) {
                if (j >= 0 && j < n) {
                    isValid[j] = false;
                }
            }
        }
        return isValid;
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            list.add(new String(chars));
        }
        return list;
    }
}