package offer.I.pass1;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * @author xinchan
 * @version 1.0.1 2022-05-01
 */
public class Offer12 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = new char[][]{{'A'}};
        Offer12 offer12 = new Offer12();
        String word = "ABCCEA";
//        String word = "AB";
        boolean exist = offer12.exist(board, word);
        System.out.println(exist);
    }

    private char[][] board;
    private char[] words;
    private int len;
    private int m;
    private int n;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean flag;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.len = word.length();
        this.m = board.length;
        this.n = board[0].length;
        this.words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        if (board[i][j] == '\0' || board[i][j] != words[k]) {
            return false;
        }
        if (k == len - 1) {
            return true;
        }
        board[i][j] = '\0';
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] != '\0') {
                if (dfs(ni, nj, k + 1)) {
                    flag = true;
                    break;
                }
            }
        }
        board[i][j] = words[k];
        return flag;
    }
}
