package crackingInterview.pass1.ch08;

/**
 * 面试题 08.01. 三步问题
 * @author xinchan
 * @version 1.0.1 2022-09-14
 */
public class Solution01 {
    public int waysToStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return n + 1;
        }
        int x = 0, y = 1, z = 2, ans = 4;
        final int MOD = 1000000007;
        for (int i = 4; i <= n; i++) {
            x = y;
            y = z;
            z = ans;
            ans = ((x % MOD + y % MOD) % MOD + z % MOD) % MOD;
        }
        return z;
    }
}
