package tencent.top50;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}

class Solution215_ {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pos = partition(nums, left, right);
        if (pos == k) {
            return nums[k];
        } else if (pos < k) {
            return quickSelect(nums, pos + 1, right, k);
        } else {
            return quickSelect(nums, left, pos - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[(left + right) >>> 1];
        while (left < right) {
            while (less(nums[left], pivot)) {
                left++;
            }
            while (less(pivot, nums[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
            if (nums[left] == pivot) {
                right--;
            }
            if (nums[right] == pivot) {
                left++;
            }
        }
        return right;
    }

    private boolean less(int x, int y) {
        return x < y;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
