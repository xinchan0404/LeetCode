package tencent.top50.pass2;

/**
 * 7. 整数反转
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution04 {
    public int reverse(int x) {
        int bit = 0;
        int ans = 0;
        while (x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            bit = x % 10;
            x /= 10;
            ans = 10 * ans + bit;
        }
        return ans;
    }
}
