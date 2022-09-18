package crackingInterview.pass1.ch08;

/**
 * @author xinchan
 * @version 1.0.1 2022-09-18
 */
public class Solution05 {
    public int multiply(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) != 0) {
                ans += (max << i);
            }
            min >>= 1;
        }
        return ans;
    }
}
