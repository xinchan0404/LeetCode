package offerDay.first.pass2.day17;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class MedianFinder {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>();
        this.minHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : minHeap.peek();
    }
}
