package tencent.top50.pass2;

/**
 * 14. 最长公共前缀
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution08 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
