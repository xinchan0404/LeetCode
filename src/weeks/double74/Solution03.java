package weeks.double74;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 6022. 将数组和减半的最少操作次数
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution03 {
    public int halveArray(int[] nums) {
        int n = nums.length;
        double sum = 0;
        int cnt = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((x, y) -> (int) (y - x));
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            priorityQueue.offer((double) nums[i]);
        }
        double original = sum;
        while (sum > original / 2) {
            double max = priorityQueue.poll() / 2;
            sum -= max;
            priorityQueue.offer(max);
            cnt++;
        }
        return cnt;
    }
}
