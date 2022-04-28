package offerDay.I.pass1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class CQueue {
    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;

    public CQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
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
}
