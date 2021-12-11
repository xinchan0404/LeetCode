package dailyTopic.Daily1211;

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
public class Daily1211TooSlow {
    public static void main(String[] args) {
        /*
         * 测试 TopVotedCandidate 类
         */
//        int[] persons = {0, 1, 1, 0, 0, 1, 0};
//        int[] times = {0, 5, 10, 15, 20, 25, 30};

//        int[] persons = {0, 1, 0, 1, 1};
//        int[] times = {24, 29, 31, 76, 81};
//        int[] q = {28, 24, 29, 77, 30, 25, 76, 75, 81, 80};

        int[] persons = {0, 0, 1, 1, 2};
        int[] times = {0, 67, 69, 74, 87};
        int[] q = {4, 62, 100, 88, 70, 73, 22, 75, 29, 10};
        Daily1211TooSlow daily1211 = new Daily1211TooSlow(persons, times);

        int candidate = 0;
        for (int i = 0; i < q.length; i++) {
            candidate = daily1211.q(q[i]);
            System.out.print(candidate + "    ");
        }
    }

    /*
     * 实例字段
     */
    private int[] persons;
    private int[] times;

    /**
     * 构造器
     *
     * @param persons
     * @param times
     */
    public Daily1211TooSlow(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    /**
     * 返回在时刻 t 在选举中领先的候选人的编号 - 逻辑可以跑通，每次计算结果没有记录，时间溢出！！
     * @param t
     * @return
     */
    public int q(int t) {
        Map<Integer, Integer> map = new HashMap<>();
        /*
         * 寻找时刻 t 在 times 数组中得位置
         */
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

        /*
         * 统计 persons 数组中每个候选人出现的频数
         */
        for (int i = 0; i < pos; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
        }

        /*
         * 统计 HashMap 中频数最大的作为返回值
         */
        int candidate = 0;
        int maxVote = 0;
        for (int i : map.keySet()) {
            if (maxVote < map.get(i)) {
                maxVote = map.get(i);
                candidate = i;
            } else if (maxVote == map.get(i)) {
                for (int j = pos - 1; j > 0; j--) {
                    if (candidate == persons[j]) {
                        break;
                    } else if (i == persons[j]) {
                        candidate = persons[j];
                        break;
                    }
                }
            }
        }
        return candidate;
    }
}
