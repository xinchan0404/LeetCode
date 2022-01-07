package codingInterviewDay.day08;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * @author xinchan
 * @version 1.0.1 2022-01-07
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        int n = 5;
        int nums = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            nums = numWays.numWays(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(nums);
    }

    /**
     * 青蛙跳台阶问题 - 动态规划
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        return 0;
    }
}
