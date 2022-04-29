package offer.I.pass1;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author xinchan
 * @version 1.0.1 2022-04-29
 */
public class Offer10_II {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 4) {
            return n;
        }
        int p = 2;
        int q = 3;
        int sum = p + q;
        for (int i = 4; i < n; i++) {
            p = q;
            q = sum;
            sum = (p + q) % 1000000007;
        }
        return sum;
    }
}
