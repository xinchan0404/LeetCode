package offerDay.first.pass2.day25;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-11
 */
public class Solution02 {
    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if ((pushed == null || pushed.length == 0) && (popped == null || popped.length == 0)) {
            return true;
        }
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (i < n || j < n) {
            if (i >= n) {
                if (!stack.isEmpty() && (stack.peek() == popped[j])) {
                    stack.pop();
                    j++;
                } else {
                    return false;
                }
            } else {
                if (pushed[i] == popped[j]) {
                    i++;
                    j++;
                } else if (!stack.isEmpty() && (stack.peek() == popped[j])) {
                    stack.pop();
                    j++;
                } else {
                    stack.push(pushed[i]);
                    i++;
                }
            }
        }
        return true;
    }

    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if ((pushed == null || pushed.length == 0) && (popped == null || popped.length == 0)) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
