package crackingTheCodingInterview.ch03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.04. 化栈为队
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class MyQueue {
    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;

    public MyQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    public void push(int value) {
        stackIn.push(value);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            if (!stackIn.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            } else {
                return -1;
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            if (!stackIn.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            } else {
                return -1;
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
