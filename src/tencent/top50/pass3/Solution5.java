package tencent.top50.pass3;

/**
 * 9. 回文数
 * @author xinchan
 * @version 1.0.1 2023-02-21
 */
public class Solution5 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int ans = 0;
        while (x > ans) {
            ans = 10 * ans + x % 10;
            x = x / 10;
        }

        return ans == x || ans / 10 == x;
    }
}
