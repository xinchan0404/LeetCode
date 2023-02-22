package tencent.top50.pass3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * @author xinchan
 * @version 1.0.1 2023-02-22
 */
public class Solution10 {
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
            } else {
                if (stack.isEmpty() || (c == ')' && stack.peek() != '(')
                        || (c == ']' && stack.peek() != '[')
                        || (c == '}' && stack.peek() != '{')) {
                    return false;
                } else {
                    stack.poll();
                }
            }
        }

        return stack.isEmpty();
    }
}
