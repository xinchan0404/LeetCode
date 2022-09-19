package crackingInterview.pass1.ch08;

/**
 * 面试题 08.11. 硬币
 * @author xinchan
 * @version 1.0.1 2022-09-19
 */
public class Solution11 {
    private int ans;
    private int cur;
    private int n;
    private int[] coins = {1, 5, 10, 25};
    private static final int MOD = 1000000007;

    public int waysToChange(int n) {
        this.ans = 0;
        this.cur = 0;
        this.n = n;

        dfs();

        return ans;
    }

    private void dfs() {
        if (cur == n) {
            ans = ans % MOD;
            ans++;
            return;
        }
        if (cur > n) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            cur += coins[i];
            dfs();
            cur -= coins[i];
        }
    }

    public static void main(String[] args) {
        Solution11 s = new Solution11();
        int ans = s.waysToChange(5);
        System.out.println(ans);
    }
}
