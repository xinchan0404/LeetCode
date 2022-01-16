package crackingTheCodingInterview.ch01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution03 {
    /**
     * 面试题 01.03. URL化 - 数组填充
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                counter++;
            }
        }

        int index = length + 2 * counter - 1;
        char[] chars1 = new char[index + 1];
        for (int i = length - 1; i > -1; i--) {
            char c = S.charAt(i);
            if (c != ' ') {
                chars1[index--] = c;
            } else {
                chars1[index--] = '0';
                chars1[index--] = '2';
                chars1[index--] = '%';
            }
        }

        return new String(chars1);
    }


    /**
     * 面试题 01.03. URL化 - StringBuilder
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces1(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        String s = "Mr John Smith    ";
        String ans = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            ans = solution03.replaceSpaces1(s, 13);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(ans);
    }
}
