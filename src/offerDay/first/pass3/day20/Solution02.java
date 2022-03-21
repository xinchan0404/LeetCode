package offerDay.first.pass3.day20;

/**
 * 剑指 Offer 16. 数值的整数次方
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution02 {
    public double myPow(double x, int n) {
        return n > 0 ? fastPower(x, n) : 1.0 / fastPower(x, -n);
    }

    private double fastPower(double x, int N) {
        if (N == 0) {
            return 1.0;
        }
        double y = fastPower(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
