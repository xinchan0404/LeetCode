package tencent.top50.pass2;

/**
 * 14. 最长公共前缀
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution08 {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if (min > len) {
                min = len;
                index = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char c = strs[index].charAt(i);
            boolean flag = true;
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
