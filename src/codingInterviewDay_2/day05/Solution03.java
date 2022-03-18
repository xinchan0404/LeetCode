package codingInterviewDay_2.day05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution03 {
    /**
     * 面试题50. 第一个只出现一次的字符 - 模拟 Map
     * @return
     */
    public char firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (cnt[index] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 面试题50. 第一个只出现一次的字符 - 队列【延迟删除】
     * @return
     */
    public char firstUniqChar1(String s) {
        class  pair {
            private char c;
            private int pos;

            public pair(char c, int pos) {
                this.c = c;
                this.pos = pos;
            }
        }
        int n = s.length();
        int[] cnt = new int[26];
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (cnt[index] == 0) {
                cnt[index]++;
                deque.offer(ch);
            } else {
                cnt[index] = -1;
                while (!deque.isEmpty() && cnt[deque.peek() - 'a'] == -1) {
                    deque.poll();
                }
            }
        }

        return !deque.isEmpty() ? deque.peek() : ' ';
    }
}
