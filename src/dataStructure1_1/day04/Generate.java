package dataStructure1_1.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 提示:
 * 1. 1 <= numRows <= 30
 *
 * @author xinchan
 * @version 1.0.1 2021-11-28
 */
public class Generate {
    public static void main(String[] args) {
        int numRows = 6;
        List<List<Integer>> list;

        list = generate(numRows);

        System.out.println(list);

    }

    /**
     * 基于 List 集合类生成杨辉三角
     * @param numsRows
     * @return
     */
    public static List<List<Integer>> generate(int numsRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numsRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(row);
        }

        return list;
    }
}
