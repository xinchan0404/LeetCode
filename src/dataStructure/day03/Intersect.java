package dataStructure.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class Intersect {
    public static void main(String[] args) {
        /*int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};*/
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        /*int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};*/
        int[] intersect;

//        intersect = intersect(nums1, nums2);
//        intersect = intersect1(nums1, nums2);  // 官方题解、HashMap
        intersect = intersect2(nums1, nums2);  // 官方题解、排序+双指针

        System.out.println("两个数组的交集：" + Arrays.toString(intersect));
    }

    /**
     * 两个数组的交集Ⅱ-HashMap
     * 说明：
     * 1. 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 2. 我们可以不考虑输出结果的顺序。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] intersect;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> interMap = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        int sumLen = 0;
        for (Integer num : map1.keySet()) {
            if (map2.containsKey(num)) {
                int minLen = Math.min(map1.get(num), map2.get(num));
                sumLen += minLen;
                interMap.put(num, minLen);
            }
        }

        int j = 0;
        intersect = new int[sumLen];
        for (Integer num : interMap.keySet()) {
            for (int i = 0; i < interMap.get(num); i++) {
                intersect[j++] = num;
            }
        }

        return intersect;
    }

    /**
     * 两个数组的交集Ⅱ-官方题解-HashMap
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        int[] smallNums = nums1.length <= nums2.length ? nums1 : nums2;
        int[] largeNums = nums1.length > nums2.length ? nums1 : nums2;
        int[] intersect = new int[smallNums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : smallNums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (int num : largeNums) {
            if (map.containsKey(num) && map.get(num) != 0) {
                map.put(num, map.get(num) - 1);
                intersect[i++] = num;
            }
        }

        intersect = Arrays.copyOf(intersect, i);
        return intersect;
    }

    /**
     * 两个数组的交集Ⅱ-排序+双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int[] intersect = new int[Math.min(nums1.length, nums2.length)];

//        Arrays.sort(nums1);
//        Arrays.sort(nums2);

        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);

        int i = 0;  // 记录交集数组当前位置
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersect[i++] = nums1[p1];
                p1++;
                p2++;
            }
        }

        return Arrays.copyOf(intersect, i);
    }

    /**
     * 快速排序-取中间位置作为 pivot 值
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        int s = start;
        int e = end;
        int pivot = nums[(s+ e) / 2];

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

        if (s == e) {
            s++;
            e--;
        }

        // 对左子序列递归快速排序
        if (start < e) {
            quickSort(nums, start, e);
        }

        // 对右子序列递归快速排序
        if (s < end) {
            quickSort(nums, s, end);
        }
    }

    public static void swap(int[] nums, int xIndex, int yIndex) {
        int tmp = nums[xIndex];
        nums[xIndex] = nums[yIndex];
        nums[yIndex] = tmp;
    }
}
