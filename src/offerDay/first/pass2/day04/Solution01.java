package offerDay.first.pass2.day04;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution01 {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
}
