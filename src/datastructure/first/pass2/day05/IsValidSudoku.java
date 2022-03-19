package datastructure.first.pass2.day05;

/**
 * 36. 有效的数独
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 * @author xinchan
 * @version 1.0.1 2021-12-15
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        /*
         * 测试 isValidSudoku()
         */
        IsValidSudoku isValidSudoku = new IsValidSudoku();

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean isValid = false;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isValid = isValidSudoku.isValidSudoku(board);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(isValid);
    }

    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] column = new int[9];

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row[board[i][j] - '1']++;
                    if (row[board[i][j] - '1'] > 1) {
                        return false;
                    }
                }

                if (board[j][i] != '.') {
                    column[board[j][i] - '1']++;
                    if (column[board[j][i] - '1'] > 1) {
                        return false;
                    }
                }
            }

            int[] subSudoku = new int[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[j + 3 * (i / 3)][k + 3 * (i % 3)] != '.') {
                        subSudoku[board[j + 3 * (i / 3)][k + 3 * (i % 3)] - '1']++;
                        if (subSudoku[board[j + 3 * (i / 3)][k + 3 * (i % 3)] - '1'] > 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
