package dataStructure1_2.day09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class IsValid {
    public static void main(String[] args) {
        /*
         * 测试 isValid()
         */
        IsValid isValid = new IsValid();
        String s = "([{}])";
        boolean validOrNot = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            validOrNot = isValid.isValid(s);  // 1000000: 38 ms
            validOrNot = isValid.isValid1(s);  // 1000000: 30 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(validOrNot);
    }

    /**
     * 是否是有效的括号 - 堆栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && (s.charAt(i) == ')' || c == ']' || c == '}')) {
                return false;
            } else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')) {
                stack.pop();
                continue;
            } else if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[') || (c == '}' && stack.peek() != '{')) {
                return false;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }

    /**
     * 是否是有效的括号 - 数组模拟堆栈
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] stack = new char[s.length()];
        int top = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (top == -1 && (c == ')' || c == ']' || c == '}')) {
                return false;
            } else if ((c == ')' && stack[top] == '(') || (c == ']' && stack[top] == '[') || (c == '}' && stack[top] == '{')) {
                top--;
                continue;
            } else if ((c == ')' && stack[top] != '(') || (c == ']' && stack[top] != '[') || (c == '}' && stack[top] != '{')) {
                return false;
            }
            stack[++top] = c;
        }

        return top == -1;
    }
}
