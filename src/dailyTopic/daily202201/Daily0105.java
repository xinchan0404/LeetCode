package dailyTopic.daily202201;

/**
 * 1576. 替换所有的问号
 *
 * @author xinchan
 * @version 1.0.1 2022-01-05
 */
public class Daily0105 {
    public static void main(String[] args) {
        Daily0105 daily0105 = new Daily0105();
//        String s = "??ac?b?";
        String s = "????";
        String modifyString = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            modifyString = daily0105.modifyString(s);  // 63 ms
            modifyString = daily0105.modifyString1(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(modifyString);
    }

    /**
     * 替换所有的问号 - charAt()
     *
     * @param s
     * @return
     */
    public String modifyString(String s) {
        int n = s.length();
        if (n == 1) {
            if (s.equals("?")) {
                return "a";
            } else {
                return s;
            }
        }

        char pre = ' ';
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '?') {
                char replace = 'a';
                if (i == 0) {
                    while (replace == s.charAt(i + 1)) {
                        replace++;
                    }
                } else if (i == n - 1) {
                    char cPre = s.charAt(i - 1);
                    while (replace == (cPre == '?' ? pre : cPre)) {
                        replace++;
                    }
                } else {
                    char cPre = s.charAt(i - 1);
                    while (replace == (cPre == '?' ? pre : cPre) || replace == s.charAt(i + 1)) {
                        replace++;
                    }
                }
                stringBuilder.append(replace);
                pre = replace;
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 替换所有的问号 - toCharArray()
     *
     * @param s
     * @return
     */
    public String modifyString1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') {
                char replace = 'a';
                while ((i > 0 && chars[i - 1] == replace) || (i < n -1 && chars[i + 1] == replace)) {
                    replace++;
                }
                chars[i] = replace;
            }
        }

        return new String(chars);
    }
}
