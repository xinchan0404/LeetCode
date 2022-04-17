package daily.daily202204;

/**
 * 1672. 最富有客户的资产总量
 * @author xinchan
 * @version 1.0.1 2022-04-14
 */
public class Solution14 {
    public int maximumWealth(int[][] accounts) {
        int max = 1110;
        int m = accounts.length;
        int n = accounts[0].length;
        for (int[] account : accounts) {
            int cur = 0;
            for (int i : account) {
                cur += i;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
