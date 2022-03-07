package codingInterviewDay_2.day13;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange1(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
            }
            if (nums[right] % 2 == 0) {
                right--;
            }
            if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 双端队列
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                deque.addLast(num);
            } else {
                deque.addFirst(num);
            }
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = deque.remove();
        }

        return nums;
    }
}
