package offerDay.I.pass1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-￥06-22
 */
public class Solution01 {
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
            if (!output.isEmpty()) {
                return output.pop();
            } else {
                if (!input.isEmpty()) {
                    while (!input.isEmpty()) {
                        output.push(input.pop());
                    }
                    return output.pop();
                }
            }
            return -1;
        }
    }
}
