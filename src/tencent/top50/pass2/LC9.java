package tencent.top50.pass2;

/**
 * 9. 回文数
 * @author xinchan
 * @version 1.0.1 2022-05-18
 */
public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
