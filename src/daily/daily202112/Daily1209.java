package daily.daily202112;

/**
 * 794. 有效的井字游戏
 * 提示：
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 *
 * @author xinchan
 * @version 1.0.1 2021-12-09
 */
public class Daily1209 {
    public static void main(String[] args) {
        /*
         * 测试 validTicTacToe()
         */
        String[] board = {"OOO", "XXO", "XXX"};

        boolean validTicTacToe = validTicTacToe(board);

        System.out.println(validTicTacToe);
    }

    /**
     * 有效的井字游戏
     *
     * @param board
     * @return
     */
    public static boolean validTicTacToe(String[] board) {
        int oNums = 0;
        int xNums = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    oNums++;
                } else if (board[i].charAt(j) == 'X') {
                    xNums++;
                }
            }
        }
        /*
         * 有一方胜利：X 或 O
         */
        if (win(board, 'X')  && !win(board, 'O') && xNums - oNums == 1) {
            return true;
        }
        if (win(board, 'O') && !win(board, 'X') && xNums == oNums) {
            return true;
        }
        /*
         * 没有胜利方
         */
        if (!win(board, 'X') && !win(board, 'O') && (xNums == oNums || xNums - oNums == 1)) {
            return true;
        }

        return false;
    }

    /**
     * 判断游戏是否胜利
     *
     * @param board
     * @param c
     * @return
     */
    public static boolean win(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            /*
             * 是否有某一行满足条件：3 个连续的相同符号
             */
            if (c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2)) {
                return true;
            }
            /*
             * 是否有某一列满足条件：3 个连续的相同符号
             */
            if (c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i)) {
                return true;
            }
        }
        /*
         * 主对角线是否满足条件
         */
        if (c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2)) {
            return true;
        }
        /*
         * 副对角线是否满足条件
         */
        if (c == board[2].charAt(0) && c == board[1].charAt(1) && c == board[0].charAt(2)) {
            return true;
        }

        return false;
    }
}
