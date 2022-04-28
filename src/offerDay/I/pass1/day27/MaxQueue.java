package offerDay.I.pass1.day27;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-12
 */
public class MaxQueue {
    /**
     * 剑指 Offer 59 - II. 队列的最大值 - 单调队列
     */
    private Deque<Integer> deque;
    private Deque<Integer> maxVal;

    public MaxQueue() {
        this.deque = new ArrayDeque<>();
        this.maxVal = new ArrayDeque<>();
    }

    public int max_value() {
        return maxVal.isEmpty() ? -1 : maxVal.peek();
    }

    public void push_back(int value) {
        deque.offer(value);
        while (!maxVal.isEmpty() && maxVal.peekLast() < value) {
            maxVal.pollLast();
        }
        maxVal.offer(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }

        int popVal = deque.poll();

        if (!maxVal.isEmpty() && maxVal.peek() == popVal) {
            maxVal.poll();
        }

        return popVal;
    }
}
