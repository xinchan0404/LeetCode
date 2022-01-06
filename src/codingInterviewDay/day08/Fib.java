package codingInterviewDay.day08;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int n = 2;
        int fn = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            fn = fib.fib(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(fn);
    }

    /**
     * 斐波那契数列 - 动态规划
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        return 0;
    }
}
