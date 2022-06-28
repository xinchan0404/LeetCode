package offerDay.I.pass1.day04;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author xinchan
 * @version 1.0.1 2022-￥06-26
 */
public class Solution02 {
    public int search(int[] nums, int target) {
        int right = binarySearch(nums, target, false);
        int left = binarySearch(nums, target, true);
        return right == -1 ? 0 : right - left + 1;
    }

    /**
     * @param flag true for left-est, false for right-est
     */
    private int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                if (flag) {
                    if (mid == 0 || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
