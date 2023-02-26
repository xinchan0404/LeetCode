package tencent.top50.pass3;

/**
 * 53. 最大子数组和
 * @author xinchan
 * @version 1.0.1 2023-02-24
 */
public class Solution17 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length, tmp = 0;

        for (int num : nums) {
            tmp += num;
            ans = Math.max(ans, tmp);
            tmp = Math.max(tmp, 0);
        }

        return ans;
    }
}
