package offerDay.first.pass2.day27;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-12
 */
public class Solution01 {
    /**
     * 剑指 Offer 59 - I. 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> (pair2[1] - pair1[1]));
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[] {i, nums[i]});
        }
        ans[0] = priorityQueue.peek()[1];
        int j = 1;
        for (int i = k; i < n; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i - k) {
                priorityQueue.poll();
            }
            priorityQueue.offer(new int[] {i, nums[i]});
            ans[j++] = priorityQueue.peek()[1];
        }
        return ans;
    }

    /**
     * 剑指 Offer 59 - I. 滑动窗口的最大值 - 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null && nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            ans[j++] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
