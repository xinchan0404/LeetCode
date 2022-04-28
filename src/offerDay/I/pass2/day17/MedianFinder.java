package offerDay.I.pass2.day17;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * @author xinchan
 * @version 1.0.1 2022-03-20
 */
public class MedianFinder {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    int cnt;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        this.cnt = 0;
    }

    public void addNum(int num) {
        if (cnt++ % 2 == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (cnt == 0) {
            return -1;
        }
        if (cnt % 2 != 0) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
