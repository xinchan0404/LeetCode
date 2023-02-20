package tencent.top10.pass5;

/**
 * 3. 无重复字符的最长子串
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution10 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] cnt = new char[128];
        int left = -1, right = -1, max = 0;

        while (++right < n) {
            int index = s.charAt(right);
            cnt[index]++;
            while (cnt[index] > 1) {
                cnt[s.charAt(++left)]--;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
