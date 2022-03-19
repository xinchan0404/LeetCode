package datastructure.first.pass1.day01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. 存在重复元素
 *
 * @author xinchan
 * @version 1.0.1 2021-11-25
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean containsOrNot;

        containsOrNot = containsDuplicate(nums);
        containsOrNot = containsDuplicate1(nums);

        System.out.println("containsOrNot=" + containsOrNot);
    }

    /**
     * 存在重复元素-排序
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 存在重复元素-HashSet
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }

        return false;
    }
}
