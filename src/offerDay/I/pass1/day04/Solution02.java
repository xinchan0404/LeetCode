package offerDay.I.pass1.day04;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution02 {
    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                if (mid >= 1 && nums[mid - 1] == target) {
                    right = mid;
                } else {
                    pos = mid;
                    break;
                }
            }
        }
        int cnt = 0;
        for (int i = pos; i < nums.length; i++) {
            if (nums[pos] == target) {
                cnt++;
            }
        }
        return cnt;
    }
}
