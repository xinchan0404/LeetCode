package offer.I.pass1;

/**
 * 剑指 Offer 14- I. 剪绳子
 * @author xinchan
 * @version 1.0.1 2022-05-02
 */
public class Offer14_I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int tens = n / 3;
        int ones = n % 3;
        if (ones == 2) {
            return (int) Math.pow(3, tens) * 2;
        } else if (ones == 1) {
            return (int) Math.pow(3, tens - 1) * 4;
        }
        return (int) Math.pow(3, tens);
    }
}

class Offer14_I_ {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
