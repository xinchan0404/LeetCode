package leetCode.monotonousStack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 901. 股票价格跨度 - 第一个小于等于
 * @author xinchan
 * @version 1.0.1 2022-02-15
 */
public class StockSpanner {
    private Deque<Integer> stack;
    private Deque<Integer> dayNums;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
        this.dayNums = new ArrayDeque<>();
    }

    public int next(int price) {
        int dayNum = 1;
        while (!stack.isEmpty() && price >= stack.peek()) {
            stack.pop();
            dayNum += dayNums.pop();
        }
        stack.push(price);
        dayNums.push(dayNum);
        return dayNum;
    }
}
