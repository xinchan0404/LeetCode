package leetCode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 提示：
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 * @author xinchan
 * @version 1.0.1 2021-12-30
 */
public class FindClosestElements {
    public static void main(String[] args) {
        /*
         * 测试 findClosestElements()
         */
        FindClosestElements findClosestElements = new FindClosestElements();
//        int[] arr = {-3, -1, 0, 1, 2};
//        int k = 1;
//        int x = -2;
//        int[] arr = {-2, -1, 1, 2, 3, 4, 5};
//        int k = 6;
//        int x = -1;
//        int[] arr = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
//        int k = 9;
//        int x = 4;
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3;
        int x = 5;
        List<Integer> list = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list = findClosestElements.findClosestElements(arr, k, x);  // 1000000: 55 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(list);
    }

    /**
     * 找到 K 个最接近的元素
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();

        if (k >= n) {
            for (int e : arr) {
                list.add(e);
            }

            return list;
        }

        if (x <= arr[0]) {
            /*
             * 如果位于左边界或左边界外
             */
            for (int e : Arrays.copyOf(arr, k)) {
                list.add(e);
            }
        } else if (x >= arr[n - 1]) {
            /*
             * 如果位于右边界或右边界外
             */
            for (int e : Arrays.copyOfRange(arr, n - k, n)) {
                list.add(e);
            }
        } else {
            int pos = binarySearch(arr, x, false);
            int left = pos - 1;
            int right = pos;
            while (right - left - 1 < k) {
                if (left < 0) {
                    right++;
                    continue;
                }
                if (right > n - 1) {
                    left--;
                    continue;
                }
                if (x - arr[left] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            }

            for (int e : Arrays.copyOfRange(arr, left + 1, right)) {
                list.add(e);
            }
        }

        return list;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @param isLeftIndex 如果 nums 中存在 target，true 找左边界，false 找有边界
     * @return 大于等于 target 的第一个位置
     */
    private int binarySearch(int[] nums, int target, boolean isLeftIndex) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (isLeftIndex && mid != 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else if (!isLeftIndex && mid != n - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }

        return left;
    }
}
