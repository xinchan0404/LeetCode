package offerDay.I.pass1.day05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * @author xinchan
 * @version 1.0.1 2022-￥06-28
 */
public class Solution03 {
    public char firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

class Solution03_ {
    public char firstUniqChar(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (cnt[c - 'a'] == 0) {
                cnt[c - 'a']++;
                deque.offer(c);
            } else {
                cnt[c - 'a'] = -1;
                while (!deque.isEmpty() && cnt[deque.peek() - 'a'] == -1) {
                    deque.poll();
                }
            }
        }
        return deque.isEmpty() ? ' ' : deque.peek();
    }

    public static void main(String[] args) {
        Solution03_ solution03_ = new Solution03_();
        String s = "adaccdcda";
        System.out.println(solution03_.firstUniqChar(s));
    }
}
