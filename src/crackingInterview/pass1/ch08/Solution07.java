package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合
 * @author xinchan
 * @version 1.0.1 2022-09-18
 */
public class Solution07 {
    private List<String> ans;
    private StringBuilder builder;
    private boolean[] visited;
    private int n;

    public String[] permutation(String S) {
        this.n = S.length();
        this.ans = new ArrayList<>();
        this.visited = new boolean[n];
        this.builder = new StringBuilder();

        backTrace(S);

        return ans.toArray(new String[0]);
    }

    private void backTrace(String s) {
        if (builder.length() == n) {
            ans.add(builder.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!visited[i]) {
                builder.append(c);
                visited[i] = true;
                backTrace(s);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }
}
