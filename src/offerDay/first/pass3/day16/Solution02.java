package offerDay.first.pass3.day16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution02 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                cnt++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[cnt] < 5;
    }
}

class Solution02_ {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (!set.add(nums[i])) {
                return false;
            }
            maxVal = Math.max(maxVal, nums[i]);
            minVal = Math.min(minVal, nums[i]);
        }
        return maxVal - minVal < 5;
    }
}
