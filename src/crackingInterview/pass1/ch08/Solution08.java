package crackingInterview.pass1.ch08;

import java.util.*;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 * @author xinchan
 * @version 1.0.1 2022-09-18
 */
public class Solution08 {
    private List<String> ans;
    private boolean[] visited;
    private int n;
    private StringBuilder builder;

    public String[] permutation(String S) {
        this.n = S.length();
        this.visited = new boolean[n];
        this.builder = new StringBuilder();
        this.ans = new ArrayList<>();

        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        backTrace(chars);

        return ans.toArray(new String[0]);
    }

    private void backTrace(char[] chars) {
        if (builder.length() == n) {
            ans.add(builder.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
             if (!visited[i]) {
                builder.append(chars[i]);
                visited[i] = true;
                backTrace(chars);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
                while (i + 1 < n && chars[i] == chars[i + 1]) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution08 s = new Solution08();
        String S = "IIIh";
        String[] permutation = s.permutation(S);
        System.out.println(Arrays.toString(permutation));
    }
}
