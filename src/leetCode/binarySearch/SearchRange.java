package leetCode.binarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i]<= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 *
 * @author xinchan
 * @version 1.0.1 2021-12-29
 */
public class SearchRange {
    public static void main(String[] args) {
        /*
         * 测试 searchRange()
         */
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 4;
        int[] range = new int[2];
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            range = searchRange.searchRange(nums, target);  // 1000000: 15 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.toString(range));
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置 - 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] range = new int[]{-1, -1};
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid != n - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    range[1] = mid;
                    break;
                }
            }
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid != 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    range[0] = mid;
                    break;
                }
            }
        }

        return range;
    }
}
