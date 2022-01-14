package daily.daily202201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Daily0114 {
    /**
     * 373. 查找和最小的K对数字 - 双指针
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        int p11 = 0;
        int p21 = 0;
        int p12 = 0;
        int p22 = 0;
        int cnt = 0;
        while (cnt < k) {
            List<Integer> list = new ArrayList<>();
            if (cnt == 0) {
                list.add(nums1[0]);
                list.add(nums2[0]);
                if (p21 + 1 == n2) {
                    p11++;
                    p21 = 0;
                } else {
                    p21++;
                }
                if (p11 + 1 < n1) {
                    p12 = p11 + 1;
                }
            } else if (nums1[p11] + nums2[p21] < nums1[p12] + nums2[p22]) {
                list.add(nums1[p11]);
                list.add(nums2[p21]);
                if (p21 + 1 == n2) {
                    if (p12 + 1 < n1) {
                        p11 = p12 + 1;
                    }
                    p21 = 0;
                } else {
                    p21++;
                }
            } else if (nums1[p11] + nums2[p21] >= nums1[p12] + nums2[p22]) {
                list.add(nums1[p12]);
                list.add(nums2[p22]);
                if (p22 + 1 == n2) {
                    if (p11 + 1 < n1) {
                        p12 = p11 + 1;
                    }
                    p22 = 0;
                } else {
                    p22++;
                }
            }
            lists.add(list);
            cnt++;
        }

        return lists;
    }

    public static void main(String[] args) {
        Daily0114 daily0114 = new Daily0114();
        int[] nums1 = {1, 4, 11};
        int[] nums2 = {2, 4, 9};
        int k = 9 ;
        List<List<Integer>> lists = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            lists = daily0114.kSmallestPairs(nums1, nums2, k);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(lists);
    }
}
