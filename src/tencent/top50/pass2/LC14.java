package tencent.top50.pass2;

/**
 * 14. 最长公共前缀
 * @author xinchan
 * @version 1.0.1 2022-￥05-22
 */
public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
