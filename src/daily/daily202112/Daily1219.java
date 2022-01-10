package daily.daily202112;

import java.util.ArrayList;
import java.util.List;

/**
 * 997. 找到小镇的法官
 * 提示：
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust[i] 互不相同
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 *
 * @author xinchan
 * @version 1.0.1 2021-12-19
 */
public class Daily1219 {
    public static void main(String[] args) {
        /*
         * 测试 findJudge()
         */
        Daily1219 daily1219 = new Daily1219();
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;
//        int[][] trust = {};
//        int n = 1;
        int judge = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            judge = daily1219.findJudge(n, trust);  // 1000000: 53 ms
            judge = daily1219.findJudge1(n, trust);  // 1000000: 46 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(judge);
    }

    /**
     * 找到小镇的法官 - 暴力遍历统计
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return n;
        }
        int len = trust.length;
        List<Integer> judgeCandidate = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!judgeCandidate.contains(trust[i][1])) {
                judgeCandidate.add(trust[i][1]);
            }
        }

        int size = judgeCandidate.size();
        for (int i = 0; i < size; i++) {
            int judge = judgeCandidate.get(i);
            int trustJudge = 0;
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (trust[j][1] == judge) {
                    trustJudge++;
                }
                if (trust[j][0] == judge) {
                    flag = false;
                    break;
                }
            }
            if (trustJudge == n - 1 && flag) {
                return judge;
            }
        }

        return -1;
    }

    /**
     * 找到小镇的法官 - 有向图的出度和入度
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge1(int n, int[][] trust) {
        int[] inDegrees = new int[n];
        int[] outDegrees = new int[n];

        for (int[] edge : trust) {
            int out = edge[0];
            int in = edge[1];

            inDegrees[in - 1]++;
            outDegrees[out - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
