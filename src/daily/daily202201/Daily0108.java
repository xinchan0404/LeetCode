package daily.daily202201;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 *
 * @author xinchan
 * @version 1.0.1 2022-01-08
 */
public class Daily0108 {
    /**
     * 格雷编码 - 超时、如果有通项还是可以的
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int len = 1 << n - 1;

        list.add(0, 0);
        list.add(1, len);

        for (int i = 1; i < len; i++) {
            int next = list.get(i - 1);
            int pre = list.get(i);
            int xor = i % 2 == 1? 1 : 1;
            list.add(i, next ^ xor);
            list.add(i + 1, pre ^ xor);
        }

        return list;
    }

    /**
     * 格雷编码 - gray code 在一定程度上是镜像对称的
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();

        list.add(0);

        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                list.add(list.get(j) + size);
            }
        }

        return list;
    }

    /**
     * 格雷编码 - gray code 编码方法，其实跟第一种方法类似，但是没想出来
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public static void main(String[] args) {
        Daily0108 daily0108 = new Daily0108();
        int n = 3;
        List<Integer> list = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
//            list = daily0108.grayCode(n);
            list = daily0108.grayCode1(n);
//            list = daily0108.grayCode2(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(list);
    }
}
