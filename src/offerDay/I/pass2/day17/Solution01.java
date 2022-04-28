package offerDay.I.pass2.day17;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution01 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> (y - x));
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }
}

class Solution01_ {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        int[] ans = new int[k];
        int pos = partition(arr, 0, arr.length - 1);
        while (pos != k) {
            if (pos > k) {
                pos = partition(arr, 0, pos - 1);
            } else {
                pos = partition(arr, pos + 1, k);
            }
        }
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) >>> 1];
        while (left < right) {
            while (less(arr[left], pivot)) {
                left++;
            }
            while (less(pivot, arr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            if (arr[left] == pivot) {
                right--;
            }
            if (arr[right] == pivot) {
                left++;
            }
        }
        return right;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
