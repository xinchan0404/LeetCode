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
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while ((left < right) && nums[left] % 2 != 0) {
                left++;
            }
            while ((left < right) && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);
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
