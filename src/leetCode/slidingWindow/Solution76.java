package leetCode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-02-21
 */
public class Solution76 {
    /**
     * 76. 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        int sn = s.length();
        int tn = t.length();
        for (int i = 0; i < tn; i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int targetSize = target.size();

        int left = 0;
        int right = 0;
        int matchNum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < sn) {
            char c = s.charAt(right);
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.getOrDefault(c, -1))) {
                    matchNum++;
                }
            }
            right++;

            while (matchNum == targetSize) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c1 = s.charAt(left);
                if (target.containsKey(c1)) {
                    if (window.get(c1).equals(target.get(c1))) {
                        matchNum--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWin = solution76.minWindow(s, t);
        System.out.println(minWin);
    }
}
