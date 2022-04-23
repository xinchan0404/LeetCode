package tencent.top50.pass1;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-23
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int first = 2;
        int second = 3;
        int ans = first + second;
        for (int i = 5; i <= n; i++) {
            first = second;
            second = ans;
            ans = first + second;
        }
        return ans;
    }
}
