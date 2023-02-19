package niuke.tonghuashun;

/**
 * 415. 字符串相加
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1, l2 = num2.length() - 1, add = 0, tmp = 0;
        StringBuilder builder = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int n2 = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            tmp = n1 + n2 + add;
            builder.append(tmp % 10);
            add = tmp / 10;
            l1--;
            l2--;
        }
        if (add == 1) {
            builder.append(add);
        }

        return builder.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        int h1 = num1.charAt(0), h2 = num2.charAt(0);
        int n1 = num1.length(), n2 = num2.length();
        if (h1 == '0' || h2 == '0') {
            return h1 == '0' ? num2 : num1;
        }
        if (h1 == '-' && h2 == '-') {
            return "-" + addStrings(num1.substring(1, n1), num2.substring(1, n2));
        } else if (h1 != '-' && h2 != '-') {
            return addStrings(num1, num2);
        } else if (h1 == '-') {
            return subStrings(num2, num1.substring(1));
        } else {
            return subStrings(num1, num2.substring(1));
        }
    }

    public String subStrings(String num1, String num2) {
        String sub1 = num1, sub2 = num2;
        boolean reverse = false;
        if (less(num1, num2)) {
            sub1 = num2;
            sub2 = num1;
            reverse = true;
        }
        int l1 = sub1.length() - 1, l2 = sub2.length() - 1, borrow = 0, tmp;
        StringBuilder builder = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 < 0 ? 0 : sub1.charAt(l1) - '0';
            int n2 = l2 < 0 ? 0 : sub2.charAt(l2) - '0';
            tmp = n1 - n2 - borrow;
            if (tmp < 0) {
                builder.append(tmp + 10);
                borrow = 1;
            } else {
                builder.append(tmp);
                borrow = 0;
            }
            l1--;
            l2--;
        }

        builder.reverse();
        int start, len = builder.length();
        for (start = 0; start < len; start++) {
            if (builder.charAt(start) != '0') {
                break;
            }
        }
        return builder.length() - start == 0 ? "0" : reverse ? "-" + builder.substring(start) : builder.substring(start);
    }

    private boolean less(String num1, String num2) {
        if (num1.length() == num2.length())
            return num1.charAt(0) < num2.charAt(0);
        return num1.length() < num2.length();
    }
}
