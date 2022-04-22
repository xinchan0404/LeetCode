package tencent.top50.pass1;

/**
 * 231. 2 的幂
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}

class Solution231_ {
    private static final int BIG = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }
}
