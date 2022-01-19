package leetCode.array.part01;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-18
 */
public class Solution01 {
    /**
     * 283. 移动零 - 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[tail++] = nums[i];
            }
        }

        for (int i = tail; i < n; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 283. 移动零 - 双指针
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                if (left != right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
                left++;
            }
            right++;
        }
    }


    /**
     * 283. 移动零 - 双指针
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int head = 0;
        int tail = n - 1;
        while (head < tail) {
            if (nums[head] == 0) {
                System.arraycopy(nums, head + 1, nums, head, tail - head);
                nums[tail] = 0;
                tail--;
            } else {
                head++;
            }
        }
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int[] nums = {0, 1, 0, 3, 12};
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            solution01.moveZeroes(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(Arrays.toString(nums));
    }
}
