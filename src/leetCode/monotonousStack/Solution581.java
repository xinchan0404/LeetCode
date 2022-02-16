package leetCode.monotonousStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 581. 最短无序连续子数组
 * @author xinchan
 * @version 1.0.1 2022-02-15
 */
public class Solution581 {
    /**
     * 排序 + 比对
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int n = nums.length;
        int[] sortedNums = new int[n];
        System.arraycopy(nums, 0, sortedNums, 0, n);
        Arrays.sort(sortedNums);

        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sortedNums[i]) {
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != sortedNums[i]) {
                right = i;
                break;
            }
        }

        return right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int right = -1;
        int left = n - 1;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(stack.pop(), left);
            }
            stack.push(i);
        }
        if (left != n - 1) {
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    right = Math.max(stack.pop(), right);
                }
                stack.push(i);
            }
            return right - left + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        int[] nums = {1,1,2,3,3,2,2};
        int minLen;
        minLen = solution581.findUnsortedSubarray1(nums);
        System.out.println(minLen);
    }
}
