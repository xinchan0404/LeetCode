package offerDay.first.pass3.day21;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution02 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
