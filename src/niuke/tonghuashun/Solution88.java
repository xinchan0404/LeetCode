package niuke.tonghuashun;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int l1 = m - 1, l2 = n - 1, cur = nums1.length - 1;
        while (l1 >= 0 || l2 >= 0) {
            if (l1 == -1) {
                nums1[cur--] = nums2[l2--];
            } else if (l2 == -1) {
                nums1[cur--] = nums1[l1--];
            } else if (nums1[l1] >= nums2[l2]) {
                nums1[cur--] = nums1[l1--];
            } else {
                nums1[cur--] = nums2[l2--];
            }
        }
    }
}
