package offerDay.first.pass2.day08;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution01 {
    /**
     * 动态规划 + 滚动数组
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        final int MOD = 1000000007;
        int first = 0;
        int second = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if (first + second >= MOD) {
                sum = (first + second) % MOD;
            } else {
                sum = first + second;
            }
            first = second;
            second = sum;
        }
        return sum;
    }
}
