package niuke.tonghuashun;

/**
 * 43. 字符串相乘
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n1 = num1.length();
        StringBuilder ans = new StringBuilder();

        for (int i = n1 - 1; i >= 0; i--) {
            int times = (num1.charAt(i) - '0');
            StringBuilder tmp = new StringBuilder(num2);
            for (int j = 0; j < times - 1; j++) {
                tmp = addStrings(tmp.toString(), num2);
            }
            if (times != 0) {
                for (int j = 0; j < n1 - i - 1; j++) {
                    tmp.append("0");
                }
                ans = addStrings(ans.toString(), tmp.toString());
            }
        }

        return ans.toString();
    }

    public StringBuilder addStrings(String num1, String num2) {

        int l1 = num1.length() - 1, l2 = num2.length() - 1, add = 0, tmp;
        StringBuilder builder = new StringBuilder();

        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 <= -1 ? 0 : num1.charAt(l1) - '0';
            int n2 = l2 <= -1 ? 0 : num2.charAt(l2) - '0';
            tmp = n1 + n2 + add;
            builder.append(tmp % 10);
            add = tmp / 10;
            l1--;
            l2--;
        }
        if (add == 1) {
            builder.append('1');
        }

        return builder.reverse();
    }
}

class Solution43_1 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        String ans = "0";

        for (int i = len1 - 1; i >= 0; i--) {
            char n1 = num1.charAt(i);
            StringBuilder single = singleMultiply(num2, n1);
            for (int j = 0; j < len1 - i - 1; j++) {
                single.append('0');
            }
            ans = addStrings(ans, single.toString());
        }
        return ans;
    }

    private StringBuilder singleMultiply(String num1, char num2) {
        int len1 = num1.length(), add = 0, mul;
        StringBuilder builder = new StringBuilder();
        int n2 = num2 - '0';

        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) -'0';
            mul = n1 * n2 + add;
            builder.append(mul % 10);
            add = mul / 10;
        }
        if (add != 0) {
            builder.append((char)(add + '0'));
        }
        return builder.reverse();
    }

    private String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1, add = 0, tmp;

        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 <= -1 ? 0 : num1.charAt(l1) - '0';
            int n2 = l2 <= -1 ? 0 : num2.charAt(l2) - '0';
            tmp = n1 + n2 + add;
            builder.append(tmp % 10);
            add = tmp / 10;
            l1--;
            l2--;
        }
        if (add == 1) {
            builder.append("1");
        }

        return builder.reverse().toString();
    }
}
