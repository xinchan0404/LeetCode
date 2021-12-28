package leetCode.binarySearch;

import java.util.Arrays;

/**
 * 704. 二分查找
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的
 * n 将在 [1, 10000]之间
 * nums 的每个元素都将在 [-9999, 9999]之间
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class Search {
    public static void main(String[] args) {
        /*
         * 测试 search()
         */
        Search search = new Search();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos = search.search(nums, target);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pos);
    }

    /**
     * 基础版本二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
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
}
