package datastructure.second.pass1.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author xinchan
 * @version 1.0.1 2021-12-25
 */
public class Merge {
    public static void main(String[] args) {
        /*
         * 测试 merge()
         */
        Merge merge = new Merge();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergeIntervals = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            mergeIntervals = merge.merge(intervals);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.deepToString(mergeIntervals));
    }

    /**
     * 合并区间 - 左端点排序
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();

        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}
