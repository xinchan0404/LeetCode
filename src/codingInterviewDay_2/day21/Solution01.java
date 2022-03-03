package codingInterviewDay_2.day21;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 15. 二进制中1的个数 = 位运算
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int num = (int) Math.pow(2, i);
            if ((n & num )== num) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int n = 11;
        int i = solution01.hammingWeight(n);
        System.out.println(i);
    }
}
