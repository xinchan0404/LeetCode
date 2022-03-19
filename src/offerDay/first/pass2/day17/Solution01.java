package offerDay.first.pass2.day17;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution01 {
    /**
     * 剑指 Offer 40. 最小的k个数 - 大根堆
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        int n = arr.length;
        Queue<Integer> priorityQueue = new PriorityQueue<>((x, y)-> (y - x)); // 基于大根堆的优先队列
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }

        return ans;
    }

    /**
     * 剑指 Offer 40. 最小的k个数 - 快排思想
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        select(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private void select(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pos = partition(arr, left, right);
        int len = pos - left + 1;
        if (k == len) {
            return;
        } else if (k < len) {
            select(arr, left, pos - 1, k);
        } else {
            select(arr, pos + 1, right, k - len);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[(left + right) >>> 1];
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            if (arr[i] == pivot) {
                j--;
            }
            if (arr[j] == pivot) {
                i++;
            }
        }
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int[] arr = {0,1,1,2,4,4,1,3,3,2};
        int k = 6;
        int[] ans = solution01.getLeastNumbers1(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}
