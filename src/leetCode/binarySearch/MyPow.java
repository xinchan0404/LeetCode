package leetCode.binarySearch;

/**
 * 50. Pow(x, n)
 *
 * @author xinchan
 * @version 1.0.1 2022-01-11
 */
public class MyPow {
    /**
     * 实现 pow(x, n)
     * @return pow(x, n)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n / 2 % 2 == 0) {
            myPow(x, n / 2);
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 2.0;
        int n = 10;
        double xn = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            xn = myPow.myPow(x, n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(xn);
    }
}
