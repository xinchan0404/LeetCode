package weeks.single287;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-03
 */
public class Solution5219 {
    public int maximumCandies(int[] candies, long k) {
//        Arrays.sort(candies);
        int n = candies.length;
        int ans = 1;
        int cnt = 0;
        while (true) {
            for (int candy : candies) {
                cnt += candy / ans;
                if (cnt >= k) {
                    break;
                }
            }
            if (cnt < k) {
                ans--;
                break;
            } else {
                ans++;
                cnt = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution5219 solution5219 = new Solution5219();
        int[] candies = {5,8,6};
        long k = 3;
        int ans = solution5219.maximumCandies(candies, k);
        System.out.println(ans);
    }
}
