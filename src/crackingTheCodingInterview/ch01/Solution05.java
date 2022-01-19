package crackingTheCodingInterview.ch01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution05 {
    /**
     * 面试题 01.05. 一次编辑 - 依据长度差分类
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int n1 = first.length();
        int n2 = second.length();
        int diff = Math.abs(n1 - n2);
        if (diff != 0 && diff != 1) {
            return false;
        }

        boolean flag = false;
        if (diff == 0) {
            for (int i = 0; i < n1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            int p1 = 0;
            int p2 = 0;
            while (p1 < n1 && p2 < n2) {
                if (first.charAt(p1) != second.charAt(p2)) {
                    if (!flag) {
                        flag = true;
                        if (n1 > n2) {
                            p1++;
                        } else {
                            p2++;
                        }
                    } else {
                        return false;
                    }
                } else {
                    p1++;
                    p2++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        String first = "apple";
        String second = "apples";
        boolean flag = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            flag = solution05.oneEditAway(first, second);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(flag);
    }
}
