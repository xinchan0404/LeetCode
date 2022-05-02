package offerDay.I.pass3.Day04;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author xinchan
 * @version 1.0.1 2022-05-02
 */
public class Solution01 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
