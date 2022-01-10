package daily.daily202112;

/**
 * 419. 甲板上的战舰
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 *
 * @author xinchan
 * @version 1.0.1 2021-12-18
 */
public class Daily1218 {
    public static void main(String[] args) {
        /*
         * 测试 countBattleships()
         */
        Daily1218 daily1218 = new Daily1218();
        int countBattleships = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            char[][] board = {
                    {'X', '.', '.', 'X'},
                    {'.', 'X', '.', 'X'},
                    {'X', '.', '.', 'X'}};
//            countBattleships = daily1218.countBattleships(board);  // 1000000 次：46 ms
            countBattleships = daily1218.countBattleships1(board);  // 1000000 次：44 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(countBattleships);
    }

    /**
     * 甲板上的战舰 - 遍历扫描
     *
     * @param board
     * @return
     */
    public int countBattleships (char[][] board){
        int counter = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        board[k][j] = '.';
                    }
                    counter++;
                }
            }
        }

        return counter;
    }

    /**
     * 甲板上的战舰 - 枚举起点
     * @param board
     * @return
     */
    public int countBattleships1(char[][] board) {
        int counter = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // 如果非第一列，检查当前方格的左边方格是否为 'X'
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    // 如果非第一行，检查当前方格的上边方格是否为 'X'
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    counter++;
                }
            }
        }

        return counter;
    }
}
