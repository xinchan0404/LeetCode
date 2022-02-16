package crackingTheCodingInterview.ch03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.05. 栈排序
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class SortedStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public SortedStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack1.push(val);
            return;
        }

        while (!stack1.isEmpty() && stack1.peek() < val) {
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

class SortedStack1 {
    private Deque<Integer> stack;

    public SortedStack1() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val <= peek()) {
            stack.push(val);
        } else {
            int tmp = stack.pop();
            push(val);
            push(tmp);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
