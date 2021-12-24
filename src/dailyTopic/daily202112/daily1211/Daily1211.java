package dailyTopic.daily202112.daily1211;

import java.util.HashMap;
import java.util.Map;

/**
 * 911. 在线选举
 * 提示：
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 109
 * times 是一个严格递增的有序数组
 * times[0] <= t <= 109
 * 每个测试用例最多调用 104 次 q
 *
 * @author xinchan
 * @version 1.0.1 2021-12-11
 */
public class Daily1211 {
    public static void main(String[] args) {
        /*
         * 测试 TopVotedCandidate 类
         */
//        int[] persons = {0, 0, 1, 1, 2};
//        int[] times = {0, 67, 69, 74, 87};
//        int[] q = {4, 62, 100, 88, 70, 73, 22, 75, 29, 10};

        int[] persons = {0, 1, 2, 2, 1};
        int[] times = {20, 28, 29, 54, 56};
        int[] q = {28, 53, 57, 29, 29, 28, 30, 20, 56, 55};

//        int[] persons = {0, 1, 1, 0, 0, 1, 0};
//        int[] times = {0, 5, 10, 15, 20, 25, 30};
//        int[] q = {3, 12, 25, 15, 24, 8};

        Daily1211 daily1211 = new Daily1211(persons, times);

        int candidate = 0;
        for (int i = 0; i < q.length; i++) {
            candidate = daily1211.q1(q[i]);
            System.out.print(candidate + "    ");
        }
    }

    /*
     * 实列字段
     */
    private int[] tops;
    private int[] times;
    private Map<Integer, Integer> map;

    /**
     * 构造器
     * 考虑投票分布数组已经给定，每个时刻的票数分布也是确定的，因此，可以提前算出每个时刻的票数第一的候选者，再进行查表
     *
     * @param persons
     * @param times
     */
    public Daily1211(int[] persons, int[] times) {
        int length = times.length;

        this.map = new HashMap<>();
        this.times = times;
        this.tops = new int[length];

        int candidate = -1;
        /*
         * 统计 persons 数组中每个候选人出现的频数
         */
        for (int i = 0; i < length; i++) {
            /*
             * 统计 persons 数组中每个候选人出现的频数
             */
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= map.getOrDefault(candidate, -1)) {
                candidate = persons[i];
            }

            tops[i] = candidate;
        }
    }

    /**
     * 返回在时刻 t 在选举中领先的候选人的编号 - 暴力遍历
     *
     * @param t
     * @return
     */
    public int q(int t) {
        int pos = 0;

        for (int i = 0; i < times.length; i++) {
            if (t < times[i]) {
                pos = i;
                break;
            } else if (t == times[i]) {
                pos = i + 1;
                break;
            } else if (t > times[times.length - 1]) {
                pos = times.length;
                break;
            }
        }

        return tops[pos - 1];
    }

    /**
     * 返回在时刻 t 在选举中领先的候选人的编号 - 二分查找
     *
     * @param t
     * @return
     */
    public int q1(int t) {
        int start = 0;
        int end = times.length - 1;

        if (t >= times[times.length - 1]) {
            return tops[times.length - 1];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (t < times[mid]) {
                end = mid;
            } else if (t > times[mid]) {
                start = mid + 1;
            }
        }

        return tops[start - 1];
    }
}
