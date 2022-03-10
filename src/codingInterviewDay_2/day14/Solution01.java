package codingInterviewDay_2.day14;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 12. 矩阵中的路径
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i > board.length || i < 0 || j > board[0].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i, j - 1, k + 1) || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
