package offerDay.I.pass1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
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

    public int min() {
        return min.peek();
    }
}
