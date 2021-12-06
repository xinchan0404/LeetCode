package dailyTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-07
 */
public class Daily1107 {
    public static void main(String[] args) {
        String s = "leetcode1124";
        char c = firstUniqChar(s);
        System.out.println(c);
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char result = ' ';

        if (s.equals(" ")) {
            return result;
        }

        char[] charArray = s.toCharArray();
        System.out.println(Arrays.toString(charArray));
        for (char c : charArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, 2);
            } else {
                hashMap.put(c, 1);
            }
        }

        Set<Character> keySet = hashMap.keySet();
        for (Character c : hashMap.keySet()) {
            if (hashMap.get(c) == 1) {
                result = c;
                break;
            }
        }

        return result;
    }
}
