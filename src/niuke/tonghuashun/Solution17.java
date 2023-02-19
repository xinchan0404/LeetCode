package niuke.tonghuashun;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution17 {
    private final String[] STRS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> list;
    private StringBuilder builder;
    private int n;

    public List<String> letterCombinations(String digits) {
        this.list = new ArrayList<>();
        this.builder = new StringBuilder();
        this.n = digits.length();

        if (Objects.equals(digits, "")) {
            return null;
        }

        recur(digits, 0);

        return list;
    }

    private void recur(String digits, int pos) {
        if (builder.length() == n) {
            list.add(builder.toString());
        } else {
            String s = STRS[digits.charAt(pos) - 50];
            int size = s.length();
            for (int i = 0; i < size; i++) {
                builder.append(s.charAt(i));
                recur(digits, pos + 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
