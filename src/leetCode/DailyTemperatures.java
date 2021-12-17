package leetCode;

import java.util.*;

/**
 * 剑指 Offer II 038. 每日温度
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-17
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        /*
         * 测试 dailyTemperature()
         */
        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] waitTime = new int[0];

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            waitTime = dailyTemperatures.dailyTemperatures(temperatures);  // 1000000 次：86 ms
            waitTime = dailyTemperatures.dailyTemperatures1(temperatures);
//            waitTime = dailyTemperatures.dailyTemperatures2(temperatures);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.toString(waitTime));
    }

    /**
     * 每日温度 - 单调栈
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] waitTime = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int curIndex = stack.pop();
                waitTime[curIndex] = i - curIndex;
            }
            stack.push(i);
        }

        return waitTime;
    }

    /**
     * 每日温度 - 单调栈、数组模拟 Stack
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] waitTime = new int[len];
        int[] stack = new int[len];
        int top = -1;

        for (int i = 0; i < len; i++) {
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                int curIndex = stack[top--];
                waitTime[curIndex] = i - curIndex;
            }
            stack[++top] = i;
        }

        return waitTime;
    }

    /**
     * 每日温度 - 暴力遍历
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] waitTime = new int[len];

        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            for (int j = i + 1; j < len; j++) {
                if (temperature < temperatures[j]) {
                    waitTime[i] = j - i;
                    break;
                }
            }
        }

        return waitTime;
    }
}
