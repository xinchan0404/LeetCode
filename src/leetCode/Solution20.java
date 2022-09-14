package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * @author xinchan
 * @version 1.0.1 2022-09-14
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || (stack.peek() == '(' && c != ')') || (stack.peek() == '[' && c != ']') || (stack.peek() == '{' && c != '}')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
