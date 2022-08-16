package tencent.top50.pass2;

/**
 * @author xinchan
 * @version 1.0.1 2022-08-16
 */
public class Solution02 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            int[] num = nums1 == null || nums1.length == 0 ? nums2 : nums1;
            int n = nums1 == null || nums1.length == 0 ? nums2.length : nums1.length;
            if (n % 2 == 0) {
                return (num[n / 2] + num[n / 2 - 1]) / 2.0;
            } else {
                return num[n / 2];
            }
        }

        int n1 = nums1.length, n2 = nums2.length;
        int mid = (n1 + n2) / 2;
        boolean even = (n1 + n2) % 2 == 0;
        int i = 0, j = 0, index = 0;
        while (i < n1 || j < n2) {
            if ((even && mid == index + 1) || (!even && mid == index)) {
                break;
            }
            if (i >= n1) {
                j++;
            } else if (j >= n2) {
                i++;
            } else if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                j++;
            }
            index++;
        }
        if (!even) {
            return Math.min(nums1[i], nums2[j]);
        }

        return (nums1[i] + nums2[j]) / 2.0;
    }
}
