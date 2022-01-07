package dailyTopic.daily202201;

import java.util.HashMap;
import java.util.Map;

/**
 * 1629. 按键持续时间最长的键
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class Daily0108 {
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
        int index = 0;
        int maxTime = releaseTimes[0];

        for (int i = 1; i < n; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && keyPassed.charAt(i) > keyPassed.charAt(index))) {
                index = i;
                maxTime = time;
            }
        }

        return keyPassed.charAt(index);
    }

    public static void main(String[] args) {
        Daily0108 daily0108 = new Daily0108();
        int[] releaseTimes = {9,29,49,50};
        String keyPassed = "cbcd";
        char slowestKey = ' ';
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            slowestKey = daily0108.slowestKey(releaseTimes, keyPassed);  // 70 ms
//            slowestKey = daily0108.slowestKey1(releaseTimes, keyPassed);  // 178 ms
            slowestKey = daily0108.slowestKey2(releaseTimes, keyPassed);  // 12 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(slowestKey);
    }
}
