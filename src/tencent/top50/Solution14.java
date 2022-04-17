package tencent.top50;

/**
 * 14. 最长公共前缀
 * @author xinchan
 * @version 1.0.1 2022-03-30
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                stringBuilder.append(strs[0].charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}

class Solution14_ {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs[0].length() == 0) {
            return "";
        }
        int n = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
