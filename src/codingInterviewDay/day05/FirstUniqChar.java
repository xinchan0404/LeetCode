package codingInterviewDay.day05;

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
        String s = "abaccdeff";
        char firstChar = ' ';
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            firstChar = firstUniqChar.firstUniqChar(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(firstChar);
    }

    /**
     * 第一个只出现一次的字符 - Map 计频
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
}
