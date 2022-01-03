package codingInterviewDay.day05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author xinchan
 * @version 1.0.1 2022-01-03
 */
public class FirstUniqChar {
    public static void main(String[] rags) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
//        String s = "abcbccadeff";
        String s = "";
        char firstChar = ' ';
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            firstChar = firstUniqChar.firstUniqChar(s);
//            firstChar = firstUniqChar.firstUniqChar1(s);
            firstChar = firstUniqChar.firstUniqChar2(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(firstChar);
    }

    /**
     * 第一个只出现一次的字符 - Map计数
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : charArray) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }

    /**
     * 第一个只出现一次的字符 - 数组计数
     *
     * @param s
     * @return
     */
    public char firstUniqChar1(String s) {
        int[] counter = new int[26];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            counter[c - 'a']++;
        }

        for (char c : charArray) {
            if (counter[c - 'a'] == 1) {
                return c;
            }
        }

        return ' ';
    }

    /**
     * 第一个只出现一次的字符 - 队列
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        int[] counter = new int[26];
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            int index = c - 'a';
            if (counter[index] == 0) {
                counter[index]++;
                deque.add(c);
            } else if (counter[index] != -1) {
                counter[index] = -1;
                while (!deque.isEmpty() && counter[deque.element() - 'a'] == -1) {
                    deque.remove();
                }
            }
        }

        return s.equals("")? ' ' : deque.isEmpty()? ' ' : deque.element();
    }
}
