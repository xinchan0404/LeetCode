package tencent.top50;

/**
 * 7. 整数反转
 * @author xinchan
 * @version 1.0.1 2022-03-30
 */
public class Solution07 {
    public int reverse(int x) {
        int ans = 0;
        int digit = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            digit = x % 10;
            x /= 10;
            ans = 10 * ans + digit;
        }
        return ans;
    }
}
