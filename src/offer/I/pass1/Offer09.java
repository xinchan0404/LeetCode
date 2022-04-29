package offer.I.pass1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * @author xinchan
 * @version 1.0.1 2022-04-29
 */
public class Offer09 {
    class CQueue {
        private Deque<Integer> input;
        private Deque<Integer> output;

        public CQueue() {
            input = new ArrayDeque<>();
            output = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            input.push(value);
        }

        public int deleteHead() {
            if (output.isEmpty()) {
                if (!input.isEmpty()) {
                    while (!input.isEmpty()) {
                        output.push(input.pop());
                    }
                } else {
                    return -1;
                }
            }
            return output.pop();
        }
    }
}
