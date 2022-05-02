package offerDay.I.pass3.Day04;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author xinchan
 * @version 1.0.1 2022-05-02
 */
public class Solution02 {
    public int search(int[] nums, int target) {
        int leftBorder = binarySearch(nums, target, false);
        int rightBorder = binarySearch(nums, target, true);
        return leftBorder == -1 ? 0 : rightBorder - leftBorder + 1;
    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (target > midVal) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                if (flag) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
