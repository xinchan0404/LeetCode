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
            majorityEle = majorityElement.majorityElement1(nums);  // 1000000: 172 ms
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
        1,1,1,4;
        1,2,2,2;
        return nums[nums.length / 2];
    }
}
