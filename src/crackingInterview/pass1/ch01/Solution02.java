package crackingInterview.pass1.ch01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution02 {
    /**
     * 面试题 01.02. 判定是否互为字符重排 - Map 记录频数
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation2(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n2; i++) {
            char c = s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 面试题 01.02. 判定是否互为字符重排 - 字符数组排序
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation1(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
