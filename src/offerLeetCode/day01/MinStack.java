package offerLeetCode.day01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈-空间换时间、辅助栈存储当前最小值
 * 提示：
 * 1. 各函数的调用总次数不超过 20000 次
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class MinStack {
    // instance field
    private Deque<Integer> minStack;
    private Deque<Integer> minValue;  // 记录当前堆栈最小值

    // constructor
    public MinStack() {
        this.minStack = new LinkedList<>();
        this.minValue = new LinkedList<>();
    }

    // methods

    /**
     * 入栈
     * 其实还可以简单优化一下，如果入栈的值比当前最小大，不必更新辅助栈
     * @param x
     */
    public void push(int x) {
        minStack.push(x);
        if (minValue.isEmpty()) {
            minValue.push(x);
        } else {
            if (minValue.peek() < x) {
                minValue.push(minValue.peek());
            } else {
                minValue.push(x);
            }
        }
    }

    public void pop() {
        minStack.pop();
        minValue.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int min() {
        return minValue.peek();
    }

    public static void main(String[] args) {
        int min;
        int top;

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        min = minStack.min();
        System.out.println(min);

        minStack.pop();

        top = minStack.top();
        System.out.println(top);

        min = minStack.min();
        System.out.println(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */