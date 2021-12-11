package dailyTopic;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        Daily1211 daily1211 = new Daily1211(persons, times);

        int candidate = daily1211.q(3);
        System.out.println(candidate);

        candidate = daily1211.q(12);
        System.out.println(candidate);

        candidate = daily1211.q(25);
        System.out.println(candidate);

        candidate = daily1211.q(15);
        System.out.println(candidate);

        candidate = daily1211.q(24);
        System.out.println(candidate);

        candidate = daily1211.q(8);
        System.out.println(candidate);
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
    public Daily1211(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    /**
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
            }
        }
        return candidate;
    }
}
