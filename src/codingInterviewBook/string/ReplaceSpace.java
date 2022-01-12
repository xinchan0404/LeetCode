package codingInterviewBook.string;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class ReplaceSpace {
    /**
     * 剑指 Offer 05. 替换空格 - StringBuilder 拼接
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : chars) {
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy.";
        String s1 = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            s1 = replaceSpace.replaceSpace(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(s1);
    }
}
