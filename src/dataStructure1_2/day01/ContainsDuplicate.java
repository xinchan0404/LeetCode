package dataStructure1_2.day01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author xinchan
 * @version 1.0.1 2021-12-11
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        /*
         * 测试 containsDuplicate()
         */
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1};
        boolean ifContains = containsDuplicate.containsDuplicate1(nums);
        System.out.println(ifContains);
    }

    /**
     * 217. 存在重复元素 - 排序
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 217. 存在重复元素 - HashSet，元素不可重复
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
