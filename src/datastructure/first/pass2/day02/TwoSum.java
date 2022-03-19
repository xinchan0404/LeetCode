package datastructure.first.pass2.day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author xinchan
 * @version 1.0.1 2021-12-11
 */
public class TwoSum {
    public static void main(String[] args) {
        /*
         * 测试 twoSum()
         */
        TwoSum twoSum = new TwoSum();

//        int[] nums = {2, 7, 11, 15};
//        int target = 22;
//        int[] nums = {3, 2, 4};
//        int target = 6;
        int[] nums = {3, 3};
        int target = 6;

        int[] pos = twoSum.twoSum(nums, target);

        System.out.println(Arrays.toString(pos));
    }

    /**
     * 两数之和 - HashMap 的 contains()
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
