package offerDay.first.pass2.day20;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution02 {
    /**
     * 剑指 Offer 16. 数值的整数次方
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n >= 0 ? fastPower(x, n) : 1.0 / fastPower(x, -n);
    }

    private double fastPower(double x, int N) {
        if (N == 0) {
            return 1.0;
        }

        double y = fastPower(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        double x = 2.0;
        int n = 10;
        double power = solution02.myPow(x, n);
        System.out.println(power);
    }
}
