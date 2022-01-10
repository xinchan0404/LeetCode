package leetCode.string;

/**
 * 415. 字符串相加：可处理超范围的整数加法
 *
 * @author xinchan
 * @version 1.0.1 2022-01-11
 */
public class AddString {
    /**
     * 字符串相加 - 对于位数不同的情况，单独处理
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();

        int tens = 0;
        while (i >= 0 && j >= 0) {
            int cur = num1.charAt(i) - '0' + num2.charAt(j) - '0' + tens;
            tens = cur / 10;
            stringBuilder.append(cur % 10);
            i--;
            j--;
        }

        if (i != j) {
            int index = i == -1? j : i;
            String remainString = i == -1? num2 : num1;
            for (int k = index; k >= 0; k--) {
                char c = remainString.charAt(k);
                if (tens == 1) {
                    if (c == '9') {
                        stringBuilder.append(0);
                    } else {
                        stringBuilder.append(c - '0' + 1);
                        tens = 0;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
        }

        return tens == 1? stringBuilder.append(1).reverse().toString() : stringBuilder.reverse().toString();
    }

    /**
     * 字符串相加 - 对于位数不同的情况，缺省位补0
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int tens = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (i >= 0 || j >= 0 || tens == 1) {
            int n1 = i <= -1? 0 : num1.charAt(i) - '0';
            int n2 = j <= -1? 0 : num2.charAt(j) - '0';
            int ans = n1 + n2 + tens;
            tens = ans / 10;
            stringBuilder.append(ans % 10);
            i--;
            j--;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddString addString = new AddString();
//        String num1 = "456";
//        String num2 = "77";
        String num1 = "45663736487376383828";
        String num2 = "77";
        String ans = num1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            ans = addString.addStrings(num1, num2);  // 195 ms
//            ans = addString.addStrings1(num1, num2);  // 214 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(ans);
    }
}
