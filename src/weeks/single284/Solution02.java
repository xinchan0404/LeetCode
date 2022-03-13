package weeks.single284;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-13
 */
public class Solution02 {
    /**
     * 5203. 统计可以提取的工件
     * @param n
     * @param artifacts
     * @param dig
     * @return
     */
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int n1 = artifacts.length;
        int n2 = dig.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            set.add(String.valueOf(dig[i][0]) + dig[i][1]);
        }
        int cnt = 0;
        for (int i = 0; i < n1; i++) {
            int[] art = artifacts[i];
            if (art[0] == art[1] && art[2] == art[3]) {
                if (set.contains(String.valueOf(art[0]) + art[1])) {
                    cnt++;
                }
            } else if (art[3] - art[0] == art[2] - art[1]) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[0]) + art[3]) &&
                        set.contains(String.valueOf(art[2]) + art[1]) && set.contains(String.valueOf(art[0]) + art[3])) {
                    cnt++;
                }
            } else if ((art[0] == art[2] && art[3] - art[1] == 1) || (art[1] == art[3] && art[2] - art[0] == 1)) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[2]) + art[3])) {
                    cnt++;
                }
            } else if (art[1] == art[3] && art[2] - art[0] == 2) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[0] + 1) + art[1]) &&
                        set.contains(String.valueOf(art[2]) + art[3])) {
                    cnt++;
                }
            } else if ((art[0] == art[2] && art[3] - art[1] == 2)) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[0]) + (art[1] + 1)) &&
                        set.contains(String.valueOf(art[2]) + art[3])) {
                    cnt++;
                }
            } else if (art[1] == art[3] && art[2] - art[0] == 3) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[0] + 1) + art[1]) &&
                        set.contains(String.valueOf(art[0] + 2) + art[1]) && set.contains(String.valueOf(art[2]) + art[3])) {
                    cnt++;
                }
            }else if ((art[0] == art[2] && art[3] - art[1] == 3)) {
                if (set.contains(String.valueOf(art[0]) + art[1]) && set.contains(String.valueOf(art[0]) + (art[1] + 1)) &&
                        set.contains(String.valueOf(art[0]) + (art[1] + 2)) && set.contains(String.valueOf(art[2]) + art[3])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int n = 2;
        int[][] artifacts = {{0,0,0,0}, {0,1,1,1}};
        int[][] dif = {{0,0}, {0,1}};
        solution02.digArtifacts(n, artifacts, dif);
    }
}
