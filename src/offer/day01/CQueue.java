package offer.day01;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 提示：
 * 1. 1 <= values <= 10000
 * 2. 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class CQueue {
    // instance field
    private LinkedList<Integer> stack1;  // 维护数据入队列
    private LinkedList<Integer> stack2;  // 维护数据出队列

    // constructor
    public CQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    // methods
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int popElement;
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                popElement = stack2.pop();
            }
        } else {
            popElement = stack2.pop();
        }

        return popElement;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */