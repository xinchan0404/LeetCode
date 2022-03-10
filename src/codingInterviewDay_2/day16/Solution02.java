package codingInterviewDay_2.day16;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution02 {
    /**
     * 剑指 Offer 61. 扑克牌中的顺子 - 排序
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }

    /**
     * 剑指 Offer 61. 扑克牌中的顺子 - Set
     * @param nums
     * @return
     */
    public boolean isStraight1(int[] nums) {
        boolean[] appear = new boolean[13];
        int maxVal = 0;
        int minVal = 13;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (appear[nums[i]]) {
                return false;
            } else {
                appear[nums[i]] = true;
            }
            maxVal = Math.max(maxVal, nums[i]);
            minVal = Math.min(minVal, nums[i]);
        }
        return maxVal - minVal < 5;
    }
}
