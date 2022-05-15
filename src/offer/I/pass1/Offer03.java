package offer.I.pass1;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer03 {
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

    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        int[] nums = {3,4,0,0,1};
        offer03.findRepeatNumber(nums);
    }
}
