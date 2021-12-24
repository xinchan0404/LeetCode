package datastructure2_1.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author xinchan
 * @version 1.0.1 2021-12-23
 */
public class MajorityElement {
    public static void main(String[] args) {
        /*
         * 测试 majorityElement()
         */
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3, 2, 3};
        int majorityEle = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            majorityEle = majorityElement.majorityElement(nums);  // 1000000: 172 ms
//            majorityEle = majorityElement.majorityElement1(nums);  // 1000000: 172 ms
            majorityEle = majorityElement.majorityElement2(nums);  // 1000000: 0 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(majorityEle);
    }

    /**
     * 多数元素 - HashMap
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int len = nums.length;
        for (int keySet : map.keySet()) {
            if (map.get(keySet) > len / 2) {
                return keySet;
            }
        }

        return -1;
    }

    /**
     * 多数元素 - 排序
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 多数元素 - BM 算法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * 多数元素 - 分治
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length);
    }

    /**
     * 分治的递归
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int majorityElementRec(int[] nums, int left, int right) {
        return 0;
    }
}
