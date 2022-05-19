package tencent.top50.pass2;

/**
 * 7. 整数反转
 * @author xinchan
 * @version 1.0.1 2022-05-18
 */
public class LC7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans >= Integer.MAX_VALUE / 10 || ans <= Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC7 lc7 = new LC7();
//        int x = 2147483647;
        int x = 463847412;
        System.out.println(lc7.reverse(x));
    }
}
