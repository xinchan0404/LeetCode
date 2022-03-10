package daily.daily202203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Daily08 {
    /**
     * 2055. 蜡烛之间的盘子
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == '|') {
                list.add(i);
            }
        }
        int size = list.size();
        int[] pos = new int[size];
        if (size == 0) {
            return pos;
        }
        for (int i = 0; i < size; i++) {
            pos[i] = list.get(i);
        }
        for (int i = 0; i < n; i++) {
            /*
             * 左边界获取第一个大于等于，右边界获取第一个小于等于
             */
            if (queries[i][1] <= pos[0] || queries[i][0] >= pos[size - 1]) {
                continue;
            }
            int right  = binarySearch(pos, queries[i][1], true);
            int left = binarySearch(pos, queries[i][0], false);
            int num = pos[right] - pos[left];
            if (num > 0) {
                ans[i] = num - (right - left);
            }
        }

        return ans;
    }

    private int binarySearch(int[] pos, int target, boolean flag) {
        int left = 0;
        int right = pos.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = pos[mid];
            if (target > midVal) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return flag ? right : left;
    }
}
