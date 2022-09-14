package crackingInterview.pass1.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * @author xinchan
 * @version 1.0.1 2022-09-14
 */
public class Solution09 {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recur(new char[2 * n], 0);
        return ans;
    }

    private void recur(char[] cur, int pos) {
        if (pos == cur.length) {
            if (isValid(cur)) {
                ans.add(new String(cur));
            }
        } else {
            cur[pos] = '(';
            recur(cur, pos + 1);
            cur[pos] = ')';
            recur(cur, pos + 1);
        }
    }

    private boolean isValid(char[] cur) {
        int cnt = 0;
        for (char c : cur) {
            if (c == '(') {
                ++cnt;
            } else {
                --cnt;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}

class Solution09_ {
    private List<String> ans;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<>();
        this.n = n;

        backTrace(new StringBuilder(), 0, 0);
        return ans;
    }

    private void backTrace(StringBuilder builder, int open, int close) {
        if (builder.length() == 2 * n) {
            ans.add(builder.toString());
        } else {
            if (open < n) {
                builder.append('(');
                backTrace(builder, open + 1, close);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (close < open) {
                builder.append(')');
                backTrace(builder, open, close + 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
