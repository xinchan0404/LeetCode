package tencent.top50.pass1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') ||
                    (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
