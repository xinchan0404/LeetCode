package dailyTopic.daily202112;

/**
 * 507. 完美数
 * 提示：
 * 1 <= num <= 108
 *
 * @author xinchan
 * @version 1.0.1 2021-12-31
 */
public class Daily1231 {
    public static void main(String[] args) {
        /*
         * 测试 checkPerfectNumber()
         */
        Daily1231 daily1231 = new Daily1231();
        int n = 28;
        boolean isPerfectNumber = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isPerfectNumber = daily1231.checkPerfectNumber(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
    }

    /**
     * 完美数
     *
     * @param n
     * @return
     */
    public boolean checkPerfectNumber(int n) {

    }
}
