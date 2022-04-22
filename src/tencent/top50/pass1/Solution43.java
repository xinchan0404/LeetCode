package tencent.top50.pass1;

/**
 * 43. 字符串相乘
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int n1 = num1.length();
        int n2 = num2.length();
        for (int i = n2 - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            for (int j = n2 - 1; j > i; j--) {
                builder.append('0');
            }
            int add = 0;
            int y = num2.charAt(i) - '0';
            for (int j = n1 - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                builder.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                builder.append(add);
            }
            ans = add(ans, builder.reverse().toString());
        }
        return ans;
    }

    private String add(String s1, String s2) {
        StringBuilder builder = new StringBuilder();
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int add = 0;
        while (n1 >= 0 || n2 >= 0 || add != 0) {
            int i1 = n1 >= 0 ? s1.charAt(n1) - '0' : 0;
            int i2 = n2 >= 0 ? s2.charAt(n2) - '0' : 0;
            int ans = i1 + i2 + add;
            builder.append(ans % 10);
            add = ans / 10;
            n1--;
            n2--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String s1 = "9";
        String s2 = "9";
        String multiply = solution43.multiply(s1, s2);
        System.out.println(multiply);
    }
}
