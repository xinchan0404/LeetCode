package offerDay.first.pass2.day14;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 12. 矩阵中的路径 - DFS
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
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
        if (k == words.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || words[k] != board[i][j]) {
            return false;
        }
        board[i][j] = '\0';
        boolean ans = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return ans;
    }
}
