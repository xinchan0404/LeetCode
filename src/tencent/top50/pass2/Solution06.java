package tencent.top50.pass2;

/**
 * 9. 回文数
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution06 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int ans = 0, bit = 0;
        while (x > ans) {
            bit = x % 10;
            x /= 10;
            ans = 10 * ans + bit;
        }
        return ans == x || ans / 10 == x;
    }
}
