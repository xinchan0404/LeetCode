package datastructure.first.pass2.day04;

import java.util.LinkedList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 提示:
 * 1 <= numRows <= 30
 *
 * @author xinchan
 * @version 1.0.1 2021-12-14
 */
public class Generate {
    public static void main(String[] args) {
        /*
         * 测试 generate()
         */
        Generate generate = new Generate();

        int numsRows = 4;

        List<List<Integer>> lists = new LinkedList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            lists = generate.generate(numsRows);  // 1000000 次：158 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(lists);
    }

    /**
     * 打印杨辉三角
     * @param numsRows
     * @return
     */
    public List<List<Integer>> generate(int numsRows) {
        List<List<Integer>> lists = new LinkedList<>();

        for (int i = 0; i < numsRows; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
