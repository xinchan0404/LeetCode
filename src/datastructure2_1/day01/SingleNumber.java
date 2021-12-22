package datastructure2_1.day01;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * 你的算法应该具有线性时间复杂度 ==O(n)==。 你可以不使用额外空间来实现吗 ==原地操作==？
 *
 * @author xinchan
 * @version 1.0.1 2021-12-23
 */
public class SingleNumber {
    public static void main(String[] args) {
        /*
         * 测试 singleNumber()
         */
        SingleNumber singleNumber = new SingleNumber();
//        int[] nums = {2, 2, 1};
        int[] nums = {4, 1, 2, 1, 2};
        int sn = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sn = singleNumber.singleNumber(nums);  // 1000000: 16 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(sn);
    }

    /**
     * 只出现一个的数字 - 排序
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[len - 1];
    }
}
