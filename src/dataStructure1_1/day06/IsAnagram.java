package dataStructure1_1.day06;

import java.util.*;

/**
 * 242. 有效的字母异位词
 * 提示:
 * 1. 1 <= s.length, t.length <= 5 * 104
 * 2. s 和 t 仅包含小写字母
 *
 * @author xinchan
 * @version 1.0.1 2021-11-30
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean isAnagram = isAnagram1(s, t);

        System.out.println("字母异位词：" + isAnagram);
    }

    /**
     * 是否为有效的字母异位词 - HashMap 记录频数
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.getOrDefault(c, -1) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 是否为有效的字母异位词 - 数组模拟 HashMap
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(countS, countT);
    }
}
