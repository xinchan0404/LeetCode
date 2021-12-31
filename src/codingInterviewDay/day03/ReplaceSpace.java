package codingInterviewDay.day03;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author xinchan
 * @version 1.0.1 2021-12-31
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        /*
         * 测试 replaceSpace()
         */
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy";
        String newS = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            newS = replaceSpace.replaceSpace(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(newS);
    }

    /**
     * 替换空格
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
