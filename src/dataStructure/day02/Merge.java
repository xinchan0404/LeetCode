package dataStructure.day02;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-24
 */
public class Merge {
    public static void main(String[] args) {
        /*
         * 测试 merge()
         */
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        merge(nums1, m, nums2, n);  // 暴力合并排序
//        merge1(nums1, m, nums2, n);  // 双指针
        merge2(nums1, m, nums2, n);  // 逆序双指针
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并两个有序数组-暴力合并排序
     * 提示：
     * 1. nums1.length == m + n
     * 2. nums2.length == n
     * 3. 0 <= m, n <= 200
     * 4. 1 <= m + n <= 200
     * 5. -109 <= nums1[i], nums2[j] <= 109
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

//        Arrays.sort(nums1);  // 快速排序，空间复杂度 O(nlogn)，空间复杂度
        quickSort(nums1, 0, nums1.length - 1);  // 自行实现快速排序
    }


    /**
     * 合并两个有序数组-双指针
     * 利用两个数组都是有序的，同时遍历两个数组，使用两个索引分别对两个数组进行标记，申请一个辅助数组用于暂记排序结果
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;  // nums1 当前位置索引
        int p2 = 0;  // nums2 当前位置索引
        int[] sorted = new int[nums1.length];  // 合并后的有序数组
        int cur = 0;  // 待插入合并后有序数组的元素

        while (p1 < m || p2 < n) {
            if (p1 == m) {  // 如果 nums1 的索引 p1 已经超过数据索引范围，依次将 nums2 剩余数据存入 sorted 中
                cur = nums2[p2++];
            } else if (p2 == n) {  // 如果 nums2 的索引 p2 已经超过数据索引范围，依次将 nums1 剩余数据存入 sorted 中
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {  // 将 nums1 和 nums2 当前位置较小的元素存入 sorted
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 合并两个有序数组-逆序双指针、原地合并
     * 利用两个数组都是有序的，同时从末尾开始遍历两个数组，使用两个索引分别对两个数组进行标记
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = 0;

        while (p1 + p2 + 1 > 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums2[p2--];
            } else {
                cur = nums1[p1--];
            }
            nums1[p1 + p2 + 2] = cur;
        }
    }

    /**
     * 自行实现快速排序
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        int s = start;
        int e = end;
        int pivot = nums[(s + e) / 2];

        while (s < e) {
            while (nums[s] < pivot) {
                s++;
            }

            while (nums[e] > pivot) {
                e--;
            }

            if (s == e) {
                break;
            }

            swap(nums, s, e);

            if (nums[s] == pivot) {
                e--;
            }

            if (nums[e] == pivot) {
                s++;
            }
        }

        // 向左递归
        if (start < e) {
            quickSort(nums, start, e - 1);
        }
        // 向右递归
        if (s > end) {
            quickSort(nums, s + 1, end);
        }
    }


    /**
     * 交换两个数组元素
     *
     * @param nums
     * @param xIndex
     * @param yIndex
     */
    public static void swap(int[] nums, int xIndex, int yIndex) {
        int tmp = nums[xIndex];
        nums[xIndex] = nums[yIndex];
        nums[yIndex] = tmp;
    }
}
