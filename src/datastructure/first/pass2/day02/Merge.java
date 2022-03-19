package datastructure.first.pass2.day02;

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

//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
//        int[] nums1 = {4, 5, 6, 0, 0, 0};
//        int[] nums2 = {1, 2, 3};
//        int[] nums1 = {0};
//        int[] nums2 = {1};
        int m = 3;
        int n = 3;

        merge.merge1(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并两个有序数组 - 直接填充再排序
     *
     * @param nums1 合并后接收数组
     * @param m nums1 有效数长度
     * @param nums2 被合并数组
     * @param n nums2 有效数长度
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
                System.arraycopy(nums2, p2, nums1, cur, n - p2);
                break;
            } else if (p2 == n) {
                System.arraycopy(nums1Copy, p1, nums1, cur, m - p1);
                break;
            } else {
                nums1[cur++] = nums1Copy[p1] <= nums2[p2]? nums1Copy[p1++] : nums2[p2++];
            }
        }
    }

    /**
     * 合并两个有序的数组 - 逆序双指针法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = nums1.length - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
                break;
            } else if (p2 == -1) {
                break;
            } else {
                nums1[cur--] = nums1[p1] <= nums2[p2]? nums2[p2--] : nums1[p1--];
            }
        }
    }
}
