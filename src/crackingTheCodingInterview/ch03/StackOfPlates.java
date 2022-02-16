package crackingTheCodingInterview.ch03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class StackOfPlates {
    private List<s> stacks;
    private int cap;

    public StackOfPlates(int cap) {
        this.cap = cap;
        stacks = new ArrayList<>();
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }

        int size = stacks.size();
        if (size > 0) {
            s s = stacks.get(size - 1);
            if (s.top < cap - 1) {
                s.stack[++s.top] = val;
                return;
            }
        }
        s s = new s(cap);
        stacks.add(s);
        s.stack[++s.top] = val;
    }

    public int pop() {
        return popAt(stacks.size() - 1);
    }

    public int popAt(int index) {
        int size = stacks.size();
        if (!stacks.isEmpty() && index <= size - 1) {
            s s = stacks.get(index);
            if (s.top > -1) {
                int ans = s.stack[s.top--];
                if (s.top == -1) {
                    stacks.remove(index);
                }
                return ans;
            }
        }
        return -1;
    }

    class s {
        int top;
        int[] stack;

        public s(int cap) {
            top = -1;
            stack = new int[cap];
        }
    }
}

class StackOfPlates1 {
    private List<Deque<Integer>> stacks;
    private int cap;

    public StackOfPlates1(int cap) {
        this.cap = cap;
        stacks = new ArrayList<>();
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }

        int size = stacks.size();
        if (stacks.isEmpty() || stacks.get(size - 1).size() >= cap) {
            Deque<Integer> stack = new ArrayDeque<>();
            stacks.add(stack);
            stack.push(val);
        } else {
            stacks.get(size - 1).push(val);
        }
    }

    public int pop() {
        return popAt(stacks.size() - 1);
    }

    public int popAt(int index) {
        int size = stacks.size();
        if (index <= size - 1 && index >= 0) {
            Deque<Integer> stack = stacks.get(index);
            if (!stack.isEmpty()) {
                int ans = stack.pop();
                if (stack.isEmpty()) {
                    stacks.remove(stack);
                }
                return ans;
            }
        }
        return -1;
    }
}