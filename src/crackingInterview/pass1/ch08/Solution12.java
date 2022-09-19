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
    private int n;
    private int[] queens;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        this.ans = new ArrayList<>();
        Arrays.fill(queens, -1);

        dfs(0);
        return ans;
    }

    private void dfs(int rows) {
        if (rows == n) {
            List<String> list = generateBoard();
            ans.add(list);
        }
//        for (int i = 0; i < n; i++) {
//            if (isValid(rows, i)) {
//                queens[rows] = i;
//                dfs(rows + 1);
//                queens[rows] = -1;
//            }
//        }
        boolean[] u = useless(rows);
        for (int i = 0; i < n; i++) {
            if (!u[i]) {
                queens[rows] = i;
                dfs(rows + 1);
            }
        }
    }

    private boolean[] useless(int row) {
        boolean[] ans = new boolean[n];
        for (int i = 0; i < row; i++) {
            for (int j : new int[]{queens[i], queens[i] + row - i, queens[i] + i - row}) {
                if (j >= 0 && j < n) {
                    ans[j] = true;
                }
            }
        }
        return ans;
    }

    private boolean isValid(int row, int column) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == column || queens[i] + row - i == column || queens[i] + i - row == column) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard() {
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
