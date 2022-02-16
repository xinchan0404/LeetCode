package leetCode.queueAndStack.bfs;

import java.util.*;

/**
 * 127. 单词接龙 - 从起点到终点的最短转换路径
 * @author xinchan
 * @version 1.0.1 2022-02-13
 */
public class Solution03 {
    private int beginStep;
    private int endStep;
    private Set<String> wordSet;

    /**
     * 朴素的 BFS - 超时
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) { // 其实不用判断
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int steps = 1;
        Deque<String> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        deque.add(beginWord);
        visited.add(beginWord);

        while (!deque.isEmpty()) {
            steps++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.remove();
                for (String next : getNext(cur)) {
                    if (!visited.contains(next) && wordList.contains(next)) {
                        if (next.equals(endWord)) {
                            return steps;
                        }
                        deque.add(next);
                        visited.add(next);
                    }
                }
            }
        }

        return 0;
    }

    private List<String> getNext(String cur) {
        List<String> list = new ArrayList<>();
        int n = cur.length();
        char[] arr = cur.toCharArray();
        for (int i = 0; i < n; i++) {
            char original = arr[i];
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (original != c) {
                    arr[i] = c;
                    list.add(new String(arr));
                }
            }
            arr[i] = original;
        }

        return list;
    }

    /**
     * 双向 BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        this.wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        return bfs(beginWord, endWord);
    }

    private int bfs(String beginWord, String endWord) {
        Deque<String> beginDeque = new ArrayDeque<>();
        Deque<String> endDeque = new ArrayDeque<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginDeque.add(beginWord);
        endDeque.add(endWord);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int ans;

        while (!beginDeque.isEmpty() && !endDeque.isEmpty()) {
            if (beginDeque.size() <= endDeque.size()) {
                beginStep++;
                ans = update(beginDeque, beginSet, endSet);
            } else {
                endStep++;
                ans = update(endDeque, endSet, beginSet);
            }
            if (ans != 0) {
                return ans;
            }
        }
        return 0;
    }

    private int update(Deque<String> deque, Set<String> curSet, Set<String> otherSet) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            String cur = deque.remove();
            int n = cur.length();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 26; k++) {
                    String next = cur.substring(0, j) + (char)('a' + k) + cur.substring(j + 1);
                    if (wordSet.contains(next)) {
                        if (curSet.contains(next)) {
                            continue;
                        }
                        if (otherSet.contains(next)) {
                            return beginStep + endStep + 1;
                        } else {
                            deque.add(next);
                            curSet.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        String beginWord = "hog";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("cog");
        int minSteps = solution03.ladderLength1(beginWord, endWord, wordList);
        System.out.println(minSteps);
    }
}
