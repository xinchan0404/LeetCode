package daily.daily202203;

import java.util.Scanner;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-04
 */
public class Daily04 {
    /**
     * 2104. 子数组范围和 - 暴力遍历
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
}
