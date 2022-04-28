package daily.daily202204;

/**
 * 905. 按奇偶排序数组
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Solution28 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                left++;
            }
            if (nums[right] != 0) {
                right--;
            }
            if (nums[left] != 0 && nums[right] == 0) {
                swap(nums, left , right);
                left++;
                right--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
