package datastructure.first.pass2.day03;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-13
 */
public class Intersect {
    public static void main(String[] args) {
        /*
         * 测试 intersect()
         */
        Intersect intersect = new Intersect();

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] intersection = new int[0];
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            intersection = intersect.intersect(nums1, nums2);  // 1000000 次：84 ms
            intersection = intersect.intersect1(nums1, nums2);  // 1000000 次：50 ms
        }
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + timeCost + " ms");

        System.out.println(Arrays.toString(intersection));
    }

    /**
     * 两个数组的交集 II - HashMap 记录频数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                intersection[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        return Arrays.copyOf(intersection, index);
    }

    /**
     * 两个数组的交集 II - 排序、双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersection[index++] = nums1[p1];
                p1++;
                p2++;
            }
        }

        return Arrays.copyOf(intersection, index);
    }
}
