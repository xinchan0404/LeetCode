package dailyTopic.daily202201;

/**
 * 1614. 括号的最大嵌套深度
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class Daily0107 {
    public static void main(String[] args) {
        Daily0107 daily0107 = new Daily0107();
        String s = "(1+(2*3)+((8)/4))+1";
        int maxDepth = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            maxDepth = daily0107.maxDepth(s);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(maxDepth);
    }

    /**
     * 括号的最大嵌套深度 - 遍历
     *
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        int maxDepth = 0;
        int counter = 0;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                counter++;
                maxDepth = Math.max(maxDepth,counter);
            }
            if (c == ')') {
                counter--;
            }
        }

        return maxDepth;
    }
}
