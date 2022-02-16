package leetCode.queueAndStack.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * @author xinchan
 * @version 1.0.1 2022-02-14
 */
public class Solution02 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
