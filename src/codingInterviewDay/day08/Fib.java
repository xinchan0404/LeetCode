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
        int n = 3;
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
     * 斐波那契数列 - 递归含有大量重复运算
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    /**
     * 斐波那契数列 - 动态规划、滚动数组
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return 0;
    }
}
