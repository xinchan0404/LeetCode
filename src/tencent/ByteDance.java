package tencent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-28
 */
public class ByteDance {
    public static void main(String[] args) {
        String s= "3[a]2[bc]";
        String test = test(s);
        System.out.println(test);
    }

    private static String test(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                LinkedList<Character> stack1 = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    stack1.addFirst(stack.pop());
                }
                stack.pop();
                Deque<Character> stack2 = new ArrayDeque<>();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    stack2.push(stack.pop());
                }
                int num = 1;
                if (!stack2.isEmpty()) {
                    StringBuilder sb1 = new StringBuilder();
                    for (Character character : stack2) {
                        sb1.append(stack2.pop());
                    }
                    num = Integer.parseInt(sb1.toString());
                }
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < stack1.size(); k++) {
                        stack.push(stack1.get(k));
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.removeLast());
        }
        return stringBuilder.toString();
    }
}
