package offer.I.pass1;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-29
 */
public class Offer10_I {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int q = 1;
        int sum = p + q;
        for (int i = 2; i < n; i++) {
            p = q;
            q = sum;
            sum = (p + q) % 1000000007;
        }
        return sum;
    }
}
