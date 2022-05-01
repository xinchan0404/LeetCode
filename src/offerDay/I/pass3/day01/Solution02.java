package offerDay.I.pass3.day01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * @author xinchan
 * @version 1.0.1 2022-04-29
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
            if (min.isEmpty() || min.peek() >= x) {
                min.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == min.peek()) {
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
