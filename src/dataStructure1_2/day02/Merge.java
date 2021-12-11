package dataStructure1_2.day02;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * @author xinchan
 * @version 1.0.1 2021-12-11
 */
public class Merge {
    public static void main(String[] args) {
        /*
         * 测试 merge()
         */
        Merge merge = new Merge();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        merge.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并两个有序数组 - 直接填充再排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);
    }

    /**
     * 合并两个有序的数组 - 双指针法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        int[] nums1Copy = Arrays.copyOf(nums1, m);

        while (p1 < m || p2 < n) {
            if (p1 == m) {

            } else if () {

            } else if (nums1Copy[p1] <= nums2[p2]) {
                nums1[cur++] = nums1Copy[p1++];
            } else {
                nums1[cur++] = nums2[p2++];
            }
        }
    }
}
