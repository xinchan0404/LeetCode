package dataStructure.day09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-06
 */
public class IsValid {
    public static void main(String[] args) {
        /*
         * 测试 isValid 方法
         */
        String s = "([{}])";

        boolean isValid = isValid(s);

        System.out.println(isValid);
    }

    /**
     * 是否为有效的括号 - 堆栈
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[')
                    || (s.charAt(i) == '}' && stack.peek() == '{')) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
