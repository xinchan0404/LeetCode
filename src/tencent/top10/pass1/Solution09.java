package tencent.top10.pass1;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution09 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int max = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int cur = 1;
            set.add(s.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (set.add(s.charAt(j))) {
                    cur++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cur);
            set.clear();
        }
        return max;
    }
}

class Solution09_ {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 1;
        int pre = 0;
        for (int right = 0; right < n; right++) {
            int left = right - 1;
            while (left >= 0 && s.charAt(left) != s.charAt(right)) {
                left--;
            }
            pre = pre < right - left ? pre + 1 : right - left;
            ans = Math.max(pre, ans);
        }
        return ans;
    }
}

class Solution09__ {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = new char[128];
        int left = -1;
        int right = -1;
        int max = 0;
        while (++right < n) {
            int index = s.charAt(right);
            chars[index]++;
            while (chars[index] > 1) {
                chars[s.charAt(++left)]--;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }
}
