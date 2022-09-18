package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 * @author xinchan
 * @version 1.0.1 2022-09-18
 */
public class Solution08 {
    private Set<String> ans;
    private boolean[] visited;
    private int n;
    private StringBuilder builder;

    public String[] permutation(String S) {
        this.n = S.length();
        this.visited = new boolean[n];
        this.builder = new StringBuilder();
        this.ans = new HashSet<>();

        backTrace(S);

//        int size = ans.size();
//        String[] strs = new String[size];
//        for (int i = 0; i < size; i++) {
//            strs[i] =
//        }
        return ans.toArray(new String[0]);
    }

    private void backTrace(String s) {
        if (builder.length() == n) {
            ans.add(builder.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                builder.append(s.charAt(i));
                visited[i] = true;
                backTrace(s);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }
}
