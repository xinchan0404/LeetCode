package leetCode.queueAndStack.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 *
 * @author xinchan
 * @version 1.0.1 2022-02-14
 */
public class Solution03 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans;
        ans = solution03.dailyTemperatures(temp);
        System.out.println(Arrays.toString(ans));
    }
}
