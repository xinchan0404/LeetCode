package daily.daily202206;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-06-13
 */
public class Daily01 {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int cnt = 0;
        int[] excepted = new int[len];
        System.arraycopy(heights, 0, excepted, 0, len);
        Arrays.sort(heights);

        for (int i = 0; i < len; i++) {
            if (heights[i] != excepted[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
