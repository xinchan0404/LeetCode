package crackingTheCodingInterview.ch03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.02. 栈的最小值
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if (min.isEmpty() || value <= min.peek()) {
            min.push(value);
        }
    }

    public void pop() {
        if (min.peek().equals(stack.pop())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
