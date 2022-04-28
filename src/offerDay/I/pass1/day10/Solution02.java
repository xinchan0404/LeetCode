package offerDay.I.pass1.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution02 {
    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串 - 动态规划、线性遍历
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int len = s.charAt(1) == s.charAt(0) ? 1 : 2;
        int ans = len;
        for (int i = 2; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(i) != s.charAt(j)) {
                j--;
            }
            len = i - j;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串 - 动态规划、双指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int j = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c));
            }
            map.put(c, i);
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}
