package tencent.top50.pass1;

/**
 * 9. 回文数
 * @author xinchan
 * @version 1.0.1 2022-03-30
 */
public class Solution09 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String s = String.valueOf(x);
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

class Solution09_ {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return reverse == x || reverse / 10 == x;
    }
}
