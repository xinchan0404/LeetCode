package leetCode.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * @author xinchan
 * @version 1.0.1 2022-02-16
 */
public class Solution496 {
    /**
     * 单调栈 + HashMap
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums2[0]);
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int n1 = nums1.length;
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
