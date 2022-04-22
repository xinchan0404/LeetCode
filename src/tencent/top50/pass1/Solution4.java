package tencent.top50.pass1;

import java.util.PriorityQueue;

/**
 * 4. 寻找两个正序数组的中位数
 * @author xinchan
 * @version 1.0.1 2022-04-17
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] nums = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i == m) {
                nums[k] = nums2[j++];
            } else if (j == n) {
                nums[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }
            k++;
        }
        return len % 2 == 0 ? (nums[len / 2 - 1] + nums[len / 2]) / 2.0 : nums[len / 2];
    }
}

class Solution4_ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0 : nums2[nums2.length / 2];
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0 : nums1[nums1.length / 2];
        }
        int m = nums1.length;
        int n = nums2.length;

        boolean even = (m + n) % 2 == 0;
        int mid = (m + n) / 2;
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m || j < n) {
            if ((!even && mid == idx) || (even && mid == idx + 1)) {
                break;
            }
            if (i == m) {
                j++;
            } else if (j == n) {
                i++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            idx++;
        }
        if (!even) {
            return Math.min(nums1[i], nums2[j]);
        }
        return (nums1[i] + nums2[j]) / 2.0;
    }
}
