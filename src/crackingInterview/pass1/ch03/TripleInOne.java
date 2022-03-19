package crackingInterview.pass1.ch03;

/**
 * 面试题 03.01. 三合一
 * @author xinchan
 * @version 1.0.1 2022-02-11
 */
public class TripleInOne {
    private int[] arr;
    private int[] tops;
    private int stackSize;

    public TripleInOne(int stackSize) {
        arr = new int[3 * stackSize];
        tops = new int[3];
        tops[0] = -1;
        tops[1] = -1 + stackSize;
        tops[2] = -1 + 2 * stackSize;
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int top = tops[stackNum];
        if (top < (stackNum + 1) * stackSize - 1) {
            arr[top + 1] = value;
            tops[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int top = tops[stackNum];
        if (top > stackNum * stackSize - 1) {
            tops[stackNum]--;
            return arr[top];
        }
        return -1;
    }

    public int peek(int stackNum) {
        int top = tops[stackNum];
        if (top > stackNum * stackSize - 1) {
            return arr[top];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return tops[stackNum] == stackNum * stackSize - 1;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.peek(0);
        tripleInOne.isEmpty(0);
    }
}
