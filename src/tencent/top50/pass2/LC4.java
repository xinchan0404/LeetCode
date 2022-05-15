package tencent.top50.pass2;

/**
 * 4. 寻找两个正序数组的中位数
 * @author xinchan
 * @version 1.0.1 2022-￥05-15
 */
public class LC4 {
    /**
     * 双指针
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        int mid = (m + n) / 2;
        boolean even = (m + n) % 2 == 0;
        while (p1 < m || p2 < n) {
            if ((!even && idx == mid) || (even && idx + 1 == mid)) {
                break;
            }
            if (p1 == m) {
                p2++;
            } else if (p2 == n) {
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
            idx++;
        }
        return even ? (nums1[p1] + nums2[p2]) / 2.0 : Math.min(nums1[p1], nums2[p2]);
    }
}
