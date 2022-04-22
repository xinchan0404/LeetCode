package daily.daily202204;

/**
 * 396. 旋转函数
 * @author xinchan
 * @version 1.0.1 2022-04-22
 */
public class Solution22 {
    public int maxRotateFunction(int[] nums) {
        int ans;
        int n = nums.length;
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += i * nums[i];
            sum += nums[i];
        }
        ans = cur;
        for (int i = 1; i < n; i++) {
            cur = cur + sum - n * nums[n - i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
