package offerDay.I.pass1.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-￥06-22
 */
public class Solution02 {
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> min;

        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            if (stack.pop().equals(min.peek())) {
                min.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
