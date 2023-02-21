package tencent.top50.pass3;

/**
 * 14. 最长公共前缀
 * @author xinchan
 * @version 1.0.1 2023-02-21
 */
public class Solution7 {
    public String longestCommonPrefix(String[] strs) {
        String start = strs[0];
        int n = strs.length, len = start.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = start.charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }

        return strs[0];
    }
}
