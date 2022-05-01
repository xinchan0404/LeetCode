package daily.daily202204;

import java.util.Arrays;

/**
 * 908. 最小差值 I
 * @author xinchan
 * @version 1.0.1 2022-04-30
 */
public class Daily30 {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        return Math.max(0, nums[nums.length - 1] - nums[0] - 2 * k);
    }
}

class Daily30_ {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(0, max - min - 2 * k);
    }
}

class Daily30__ {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        return Math.max(0, max - min - 2 * k);
    }
}
