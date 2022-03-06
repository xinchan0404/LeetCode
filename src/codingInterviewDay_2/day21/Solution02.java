package codingInterviewDay_2.day21;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution02 {
    /**
     * 剑指 Offer 65. 不用加减乘除做加法 -
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
