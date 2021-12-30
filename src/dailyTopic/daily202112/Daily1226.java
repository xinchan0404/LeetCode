package dailyTopic.daily202112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1078. Bigram 分词
 * 提示：
 * 1 <= text.length <= 1000
 * text 由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-26
 */
public class Daily1226 {
    public static void main(String[] args) {
        /*
         * 测试 findOccurrence()
         */
        Daily1226 daily1226 = new Daily1226();
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] thirds = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            thirds = daily1226.findOccurrences(text, first, second);  // 1000000: 444 ms
            thirds = daily1226.findOccurrences1(text, first, second);  // 1000000: 380 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.toString(thirds));
    }

    /**
     * Bigram 分词 - split()
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int len = words.length;

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }

        return list.toArray(new String[0]);
    }

    /**
     * Bigram 分词 - 优化存储空间
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOccurrences1(String text, String first, String second) {
        String p1 = null;
        String p2 = null;
        String p3 = null;
        int nums = 0;
        int prePos = 0;
        int len = text.length();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ' || i == len - 1) {
                if (nums == 0) {
                    p1 = text.substring(0, i);
                    prePos = i + 1;
                    nums++;
                } else if (nums == 1) {
                    p2 = text.substring(prePos, i);
                    prePos = i + 1;
                    nums++;
                } else if (nums == 2) {
                    if (i == len - 1) {
                        i++;
                    }
                    p3 = text.substring(prePos, i);
                    prePos = i + 1;
                    if (p1.equals(first) && p2.equals(second)) {
                        list.add(p3);
                    }
                    p1 = p2;
                    p2 = p3;
                }
            }
        }

        return list.toArray(new String[0]);
    }
}
