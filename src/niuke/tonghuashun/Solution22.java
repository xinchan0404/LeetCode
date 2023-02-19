package niuke.tonghuashun;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution22 {
    private List<String> list;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.list = new ArrayList<>();
        this.n = n;

        recur(new char[2 * n], 0);

        return list;
    }

    private void recur(char[] chars, int size) {
        if (size == 2 * n) {
            if (isValid(chars)) {
                list.add(new String(chars));
            }
        } else {
            chars[size] = '(';
            recur(chars, size + 1);
            chars[size] = ')';
            recur(chars, size + 1);
        }
    }

    private boolean isValid(char[] chars) {
        int cnt = 0;
        for (char c : chars) {
            cnt += c == '(' ? 1 : -1;
            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }
}

class Solution22_1 {
    private List<String> list;
    private int n;
    private int size;

    public List<String> generateParenthesis(int n) {
        this.list = new ArrayList<>();
        this.n = n;

        recur(new StringBuilder(), 0, 0);

        return list;
    }

    private void recur(StringBuilder builder, int left, int right) {
        if (builder.length() == 2 * n) {
            list.add(builder.toString());
        }
        if (left < n) {
            builder.append('(');
            recur(builder, left + 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(')');
            recur(builder, left, right + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
