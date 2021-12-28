package leetCode.binarySearch;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class Search1 {
    public static void main(String[] args) {
        /*
         * 测试 search1()
         */
        Search1 search1 = new Search1();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1,3};
        int[] nums = {8, 9, 2, 3, 4};
        int target = 9;
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            pos = search1.search(nums, target);  // 1000000: 1 ms
            pos = search1.search1(nums, target);  // 1000000: 6 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pos);
    }

    /**
     * 搜索旋转排序数组 - 分段二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                int res = binarySearch(nums, left, mid - 1, target);
                if (res != -1) {
                    return res;
                } else {
                    left = mid + 1;
                }
            } else {
                int res = binarySearch(nums, mid + 1, right, target);
                if (res != -1) {
                    return res;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 搜索旋转排序数组 - 分段二分查找、官方题解
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target? 0 : -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
