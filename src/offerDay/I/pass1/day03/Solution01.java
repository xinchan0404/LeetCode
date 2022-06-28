package offerDay.I.pass1.day03;

/**
 * 剑指 Offer 05. 替换空格
 * @author xinchan
 * @version 1.0.1 2022-￥06-25
 */
public class Solution01 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
