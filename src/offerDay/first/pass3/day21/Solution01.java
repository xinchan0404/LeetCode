package offerDay.first.pass3.day21;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution01 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 1; i <= 32; i++) {
            if (((1 << i) & n) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
