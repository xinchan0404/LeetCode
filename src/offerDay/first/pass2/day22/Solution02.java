package offerDay.first.pass2.day22;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution02 {
    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if ((nums[i] ^ nums[i + 1]) == 0) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II - 有限状态机
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] nums = {3, 4, 3, 3};
        int i = solution02.singleNumber(nums);
        System.out.println(i);
    }
}
