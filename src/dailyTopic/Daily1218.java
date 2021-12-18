package dailyTopic;

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
        char[][] board = {};
        int countBattleships = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            countBattleships = daily1218.countBattleships(board);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(countBattleships);
    }

    /**
     * 甲板上的战舰
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {

    }
}
