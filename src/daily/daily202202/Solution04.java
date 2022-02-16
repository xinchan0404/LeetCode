package daily.daily202202;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-02-04
 */
public class Solution04 {
    /**
     * 1725. 可以形成最大正方形的矩形数目
     * @param rectangles
     * @return
     */
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int num = 0;
        for (int[] arr : rectangles) {
            int len = Math.min(arr[0], arr[1]);
            if (maxLen < len) {
                maxLen = len;
                num = 1;
            } else if (maxLen == len) {
                num++;
            }
        }

        return num;
    }
}
