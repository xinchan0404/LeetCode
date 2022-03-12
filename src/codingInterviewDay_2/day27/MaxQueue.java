package codingInterviewDay_2.day27;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-12
 */
public class MaxQueue {
    private Deque<Integer> queue;
    private Deque<Integer> stack;
    /**
     * 剑指 Offer 59 - II. 队列的最大值
     */
    public MaxQueue() {
        this.queue = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }

    public int max_value() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            stack.push(Math.max(value, stack.peek()));
        }
    }

    public int pop_front() {
        int popVal = -1;
        if (!queue.isEmpty()) {
            popVal = queue.remove();
        }
        if (!stack.isEmpty() && popVal == stack.peek()) {
            stack.pop();
        }
        return popVal;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        int maxVal = maxQueue.max_value();
        System.out.println(maxVal);
    }
}
