package dataStructure1_1.day09;

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
 * @version 1.0.1 2021-12-06
 */
public class MyQueue {
    /*
     * main 方法
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    /*
     * instance field
     */
    Deque<Integer> stack1;  // input
    Deque<Integer> stack2;  // output

    /*
     * constructor
     */
    public MyQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    /*
     * methods
     */
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int popVal;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            popVal = stack2.pop();
        } else {
            popVal = stack2.pop();
        }

        return popVal;
    }

    public int peek() {
        int peekVal = -1;
        if (stack2.isEmpty() && !stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        peekVal = stack2.peek();

        return peekVal;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
