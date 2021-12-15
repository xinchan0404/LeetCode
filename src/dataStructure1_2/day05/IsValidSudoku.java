package dataStructure1_2.day05;

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
                    if (row[board[i][j] - '1'] > 1) {
                        return false;
                    } else {
                        row[board[i][j] - '1']++;
                    }
                }

                if (board[j][i] != '.') {
                    if (column[board[j][i] - '1'] > 1) {
                        return false;
                    } else {
                        column[board[j][i] - '1']++;
                    }
                }
            }
        }

        int[][][] subSudoku = new int[9][3][3];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                subSudoku[index++][i % 3][j % 3] = board[i][j];
            }
        }

        return true;
    }
}
