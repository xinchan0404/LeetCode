package dailyTopic.daily202201;

import java.util.HashMap;
import java.util.Map;

/**
 * 1629. 按键持续时间最长的键
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class Daily0109 {
    /**
     * 按键持续时间最长的键
     *
     * @param releaseTimes
     * @param keyPassed
     * @return
     */
    public char slowestKey(int[] releaseTimes, String keyPassed) {
        int n = releaseTimes.length;
        int[] counter = new int[26];

        for (int i = 0; i < n; i++) {
            int index = keyPassed.charAt(i) - 'a';
            counter[index] = i == 0? releaseTimes[0] : Math.max(releaseTimes[i] - releaseTimes[i - 1], counter[index]);
        }

        int index = 0;
        for (int i = 1; i < 26; i++) {
            if (counter[i] >= counter[index]) {
                index = i;
            }
        }

        return (char)(97 + index);
    }

    /**
     * 按键持续时间最长的键 - Map
     *
     * @param releaseTimes
     * @param keyPassed
     * @return
     */
    public char slowestKey1(int[] releaseTimes, String keyPassed) {
        int n = releaseTimes.length;
        int[] counter = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = keyPassed.charAt(i);
            if (i == 0) {
                map.put(c, releaseTimes[0]);
            } else {
                map.put(c, Math.max(releaseTimes[i] - releaseTimes[i - 1], map.getOrDefault(c, 0)));
            }
        }

        char ans = 'a';
        for (Character c : map.keySet()) {
            if (map.get(c) > map.getOrDefault(ans, 0) || (map.get(c).equals(map.getOrDefault(ans, 0)) && c > ans)) {
                ans = c;
            }
        }

        return ans;
    }

    /**
     * 按键持续时间最长的键 - 记录 index
     *
     * @param releaseTimes
     * @param keyPassed
     * @return
     */
    public char slowestKey2(int[] releaseTimes, String keyPassed) {
        int n = keyPassed.length();
//        int index = 0;
        char ans = keyPassed.charAt(0);
        int maxTime = releaseTimes[0];

        for (int i = 1; i < n; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            char key = keyPassed.charAt(i);
            if (time > maxTime || (time == maxTime && key > ans)) {
                ans = key;
                maxTime = time;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Daily0109 daily0109 = new Daily0109();
        int[] releaseTimes = {9,29,49,50};
        String keyPassed = "cbcd";
        char slowestK = ' ';
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            slowestKey = daily0108.slowestKey(releaseTimes, keyPassed);  // 70 ms
//            slowestKey = daily0108.slowestKey1(releaseTimes, keyPassed);  // 178 ms
            slowestK = daily0109.slowestKey2(releaseTimes, keyPassed);  // 12 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(slowestK);
    }
}
