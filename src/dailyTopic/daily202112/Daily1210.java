package dailyTopic.daily202112;

import java.util.Arrays;

/**
 * 748. 最短补全词
 * 提示：
 * 1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-10
 */
public class Daily1210 {
    public static void main(String[] args) {
        /*
         * 测试 shortestCompletingWord()
         */
//        String licensePlate = "1s3 PSt";
//        String[] words = {"step", "steps", "stripe", "stepple"};
//        String licensePlate = "iMSlpe4";
//        String[] words = {"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"};
//        String licensePlate = "1s3 456";
//        String[] words = {"looks", "pest", "stew", "show"};
        String licensePlate = "Ar16259";
        String[] words = {"nature","though","party","food","any","democratic","building","eat","structure","our"};

        String shortestCompletingWord = shortestCompletingWord(licensePlate, words);

        System.out.println(shortestCompletingWord);
    }

    /**
     * 最短补全词 - 数组模拟
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateArray = new int[26];
        int licenseLength = 0;

        for (int i = 0; i < licensePlate.length(); i++) {
            int index = licensePlate.toLowerCase().charAt(i) - 'a';
            if (index >= 0) {
                licensePlateArray[index]++;
                licenseLength++;
            }
        }

        String shortestCompletingWord = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < licenseLength) {
                continue;
            }
            int[] licensePlateArrayCopy = Arrays.copyOf(licensePlateArray, licensePlateArray.length);
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                licensePlateArrayCopy[index]--;
            }

            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (licensePlateArrayCopy[j] > 0) {
                    flag = false;
                    break;
                }
            }

            if (flag && (shortestCompletingWord == null || shortestCompletingWord.length() > words[i].length())) {
                shortestCompletingWord = words[i];
            }
        }

        return shortestCompletingWord;
    }
}
