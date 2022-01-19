package crackingTheCodingInterview.ch01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution06 {
    /**
     * 面试题 01.06. 字符串压缩 - StringBuilder、遍历
     * @param S
     * @return
     */
    public String compressString(String S) {
        int n = S.length();
        if (n == 0) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(S.charAt(0));
        int last = S.charAt(0);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            char c = S.charAt(i);
            if (c == last) {
                cnt++;
            } else {
                stringBuilder.append(cnt);
                stringBuilder.append(c);
                last = c;
                cnt = 1;
            }
        }
        stringBuilder.append(cnt);

        return stringBuilder.length() < n? stringBuilder.toString() : S;
    }
}
