package offer.I.pass1;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * @author xinchan
 * @version 1.0.1 2022-05-01
 */
public class Offer13 {
    private int cnt = 1;
    private final int[][] dirs = {{0, 1}, {1, 0}};
    private int m;
    private int n;
    private int k;
    private boolean[] visited;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m * n];

        dfs(0, 0);

        return cnt;
    }

    private void dfs(int i, int j) {
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni * n + nj] && getSum(ni) + getSum(nj) <= k) {
                visited[ni * n + nj] = true;
                cnt++;
                dfs(ni, nj);
            }
        }
    }

    private int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int k = 17;
        Offer13 offer13 = new Offer13();
        int cnt = offer13.movingCount(m, n, k);
        System.out.println(cnt);
    }
}
