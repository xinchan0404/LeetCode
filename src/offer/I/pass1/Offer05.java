package offer.I.pass1;

/**
 * 剑指 Offer 05. 替换空格
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
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
