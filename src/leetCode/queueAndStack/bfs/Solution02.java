package leetCode.queueAndStack.bfs;

import java.util.*;

/**
 * 752. 打开转盘锁
 * @author xinchan
 * @version 1.0.1 2022-02-12
 */
public class Solution02 {
    private Set<String> deadSet;
    private int beginSteps;
    private int endSteps;

    /**
     * 朴素 BFS
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        int steps = 0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.add("0000");
        visited.add("0000");
        while (!deque.isEmpty()) {
            steps++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String s = deque.remove();
                for (String nextStatus : getNextStatus(s)) {
                    if (!visited.contains(nextStatus) && !deadSet.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return steps;
                        }
                        deque.add(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getNextStatus(String status) {
        List<String> list = new ArrayList<>();
        char[] statusArray = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num  = statusArray[i];
            statusArray[i] = num == '9'? '0' : (char)(num + 1);
            list.add(new String(statusArray));
            statusArray[i] = num == '0'? '9' : (char)(num - 1);
            list.add(new String(statusArray));
            statusArray[i] = num;
        }
        return list;
    }

    /**
     * 双向 BFS
     * @param deadends
     * @param target
     * @return
     */
    public int openLock1(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        this.deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }

        Deque<String> beginDeque = new ArrayDeque<>();
        Deque<String> endDeque = new ArrayDeque<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginDeque.add("0000");
        endDeque.add(target);
        beginSet.add("0000");
        endSet.add(target);

        while (!beginDeque.isEmpty() && !endDeque.isEmpty()) {
            int ans = -1;
            if (beginDeque.size() <= endDeque.size()) {
                beginSteps++;
                ans = update(beginDeque, beginSet, endSet);
            } else {
                endSteps++;
                ans = update(endDeque, endSet, beginSet);
            }
            if (ans != -1) {
                return ans;
            }
        }

        return -1;
    }

    private int update(Deque<String> deque, Set<String> curSet, Set<String> otherSet) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            String cur = deque.remove();
            for (String next : getNext(cur)) {
                if (!deadSet.contains(next)) {
                    if (curSet.contains(next)) {
                        continue;
                    }
                    if (otherSet.contains(next)) {
                        return beginSteps + endSteps;
                    } else {
                        deque.add(next);
                        curSet.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = cur.charAt(i);
            String curUp = cur.substring(0, i) + (c == '9' ? '0' : (char)(c + 1)) + cur.substring(i + 1);
            list.add(curUp);
            String curDown = cur.substring(0, i) + (c == '0' ? '9' : (char)(c - 1)) + cur.substring(i + 1);
            list.add(curDown);
        }
        return list;
    }
}
