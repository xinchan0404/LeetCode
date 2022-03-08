package codingInterviewDay_2.day05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution03 {
    /**
     * 面试题50. 第一个只出现一次的字符
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
}
