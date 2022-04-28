package offerDay.I.pass1.day08;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution02 {
    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题 - 滚动数组
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int sum = 2;
        final int MOD = 1000000007;
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
