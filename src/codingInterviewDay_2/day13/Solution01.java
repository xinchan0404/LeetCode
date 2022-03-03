package codingInterviewDay_2.day13;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 暴力
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int even = -1;  // 第一个偶数的位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                if (even == -1) {
                    even = i;
                }
            } else {
                if (i > even && even != -1) {
                    int tmp = nums[i];
                    nums[i] = nums[even];
                    nums[even] = tmp;
                    for (int j = even + 1; j <= i; j++) {
                        if (nums[j] % 2 == 0) {
                            even = j;
                            break;
                        }
                    }
                }
            }
        }

        return nums;
    }

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 暴力
     *
     * @param nums
     * @return
     */
    public int[] exchange1(int[] nums) {
        return null;
    }
}
