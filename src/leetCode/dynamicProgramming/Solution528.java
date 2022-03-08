package leetCode.dynamicProgramming;

import java.util.Random;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution528 {
    private int[] pre;
    private Random random;
    private int sum;

    public Solution528(int[] w) {
        this.random = new Random();
        this.pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        this.sum = pre[w.length - 1];
    }

    public int pickIndex() {
        int pickIndex = random.nextInt(sum);
        return binarySearch(pickIndex);
    }

    private int binarySearch(int target) {
        int left = 0;
        int right = pre.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = pre[mid];
            if (target > midVal) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return left;
    }
}
