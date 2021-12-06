package dataStructure.day06;

import java.util.*;

/**
 * 387. 字符串中的第一个唯一字符
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @author xinchan
 * @version 1.0.1 2021-11-30
 */
public class FirstUniqChar {
    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";

        int loc = 0;

        loc = firstUniqChar2(s);

        System.out.println("唯一字符第一次出现的次数：" + loc);
    }

    /**
     * 字符串中的第一个唯一字符 - HashMap 存储频数
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 字符串中的第一个唯一字符 - 数组模拟 HashMap
     *
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 字符串中的第一个唯一字符 - HashMap 存储索引值
     *
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != -1) {
                return map.get(c);
            }
        }

        return -1;
    }

    /**
     * 字符串中的第一个唯一字符 - 队列
     * @param s
     * @return
     */
//    public static int firstUniqChar(String s) {
//
//    }
}
