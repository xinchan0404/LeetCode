package tencent.top50.pass3;

/**
 * 43. 字符串相乘
 * @author xinchan
 * @version 1.0.1 2023-02-24
 */
public class Solution15 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num2.length();
        String ans = "0";

        for (int i = 0; i < n; i++) {
            String mul = mulStrings(num1, num2.charAt(i)) + repeatChar('0', n - i - 1);
            ans = addStrings(ans, mul);
        }

        return ans;
    }

    private String repeatChar(char c, int times) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

    private String mulStrings(String num1, char c) {
        if (c == '0') {
            return "0";
        }
        int p1 = num1.length() - 1, add = 0, n2 = c - '0';
        StringBuilder builder = new StringBuilder();

        while (p1 >= 0) {
            int n1 = num1.charAt(p1) - '0';
            int tmp = n1 * n2 + add;
            builder.append(tmp % 10);
            add = tmp / 10;
            p1--;
        }
        if (add != 0) {
            builder.append(add);
        }

        return builder.reverse().toString();
    }

    private String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1, add = 0;
        StringBuilder builder = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 <= -1 ? 0 : num1.charAt(p1) - '0';
            int n2 = p2 <= -1 ? 0 : num2.charAt(p2) - '0';
            int tmp = n1 + n2 + add;
            builder.append(tmp % 10);
            add = tmp / 10;
            p1--;
            p2--;
        }
        if (add == 1) {
            builder.append('1');
        }

        return builder.reverse().toString();
    }
}
