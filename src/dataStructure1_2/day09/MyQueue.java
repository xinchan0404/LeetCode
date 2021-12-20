package dataStructure1_2.day09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class MyQueue {
    public static void main(String[] args) {
        /*
         * 测试 MyQueue class
         */
        MyQueue myQueue = new MyQueue();
        int top = 0;
        int pop = 0;
        boolean isEmpty = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            myQueue.push(1);
            myQueue.push(2);
            top = myQueue.peek();
            pop = myQueue.pop();
            isEmpty = myQueue.empty();
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(top);
        System.out.println(pop);
        System.out.println(isEmpty);
    }

    /*
     * instance field
     */
    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new LinkedList<>();
        this.stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
