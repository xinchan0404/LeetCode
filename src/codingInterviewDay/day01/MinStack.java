package codingInterviewDay.day01;

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
    /*
     * instance field
     */
    private Deque<Integer> minStack;
    private Deque<Integer> minValue;  // 记录当前堆栈最小值

    /*
     * constructor
     */
    public MinStack() {
        this.minStack = new LinkedList<>();
        this.minValue = new LinkedList<>();
    }

    /*
     * methods
     */
    /**
     * 入栈
     * @param x
     */
    public void push(int x) {
        minStack.push(x);
        if (minValue.isEmpty() || minValue.peek() >= x) {
            minValue.push(x);
        }
    }

    public void pop() {
        if (minStack.pop() <= minValue.peek()) {
            minValue.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int min() {
        return minValue.peek();
    }

    public static void main(String[] args) {
        int min1 = 0;
        int min2 = 0;
        int top = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);

            min1 = minStack.min();

            minStack.pop();

            top = minStack.top();

            min2 = minStack.min();
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(min1);
        System.out.println(top);
        System.out.println(min2);
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