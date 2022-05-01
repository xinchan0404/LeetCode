package offerDay.I.pass3.day03;

/**
 * 剑指 Offer 05. 替换空格
 * @author xinchan
 * @version 1.0.1 2022-05-01
 */
public class Solution01 {
    public String replaceSpace(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                builder.append(c);
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }
}
