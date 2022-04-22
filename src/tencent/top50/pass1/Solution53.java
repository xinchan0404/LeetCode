package tencent.top50.pass1;

/**
 * 53. 最大子数组和
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int pre = Integer.MIN_VALUE;
        for (int num : nums) {
            if (pre <= 0) {
                pre = Math.max(pre, num);
            } else {
                pre = pre + num;
            }
            max = Math.max(pre, max);
        }
        return max;
    }
}
