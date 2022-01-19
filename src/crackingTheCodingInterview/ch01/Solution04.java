package crackingTheCodingInterview.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution04 {
    /**
     * 面试题 01.04. 回文排列 - 位运算
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        long high64 = 0L;
        long low64 = 0L;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 64) {
                high64 ^= (1L << s.charAt(i) - 64);
            } else {
                low64 ^= (1L << s.charAt(i));
            }
        }

        return Long.bitCount(high64) + Long.bitCount(low64) <= 1;
    }


    /**
     * 面试题 01.04. 回文排列 - Map 频数
     * @param s
     * @return
     */
    public boolean canPermutePalindrome1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean flag = false;
        for (int v : map.values()) {
            if (v % 2 != 0) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
