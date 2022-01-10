package daily.daily202201;

/**
 * 306. 累加数
 * @author xinchan
 * @version 1.0.1 2022-01-09
 */
public class Daily0110 {
    /**
     * 累加数
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            String a = num.substring(0, i);
            for (int j = 1; i + j < n; j++) {
                if (num.charAt(i) == '0' && j != 1) {
                    continue;
                }
                String b = num.substring(i, i + j);
                if (isAdditive(a, b, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 累加序列的性质，一旦第一个数字和第二个数字确定后，整个序列就确定了
     *
     * @param a
     * @param b
     * @param num
     * @return
     */
    private boolean isAdditive(String a, String b, String num) {
        int n = num.length();
        StringBuilder stringBuilder = new StringBuilder(a + String.valueOf(b));

        while (stringBuilder.length() < n) {
            String sum = stringAdd(a, b);
            a = b;
            b = sum;
            stringBuilder.append(sum);
        }

        return stringBuilder.toString().equals(num);
    }

    /**
     * 字符串加法
     *
     * @param a
     * @param b
     * @return
     */
    private String stringAdd(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int tens = 0;
        while (i >= 0 && j >= 0) {
            int cur = a.charAt(i) - '0' + b.charAt(j) - '0' + tens;
            tens = cur / 10;
            int ones = cur % 10;
            stringBuilder.append(ones);
            i--;
            j--;
        }
        if (i != j) {
            int max = Math.max(i, j);
            String remain = i == max? a : b;
            for (int k = max; k >= 0; k--) {
                if (tens != 0) {
                    int ones = (remain.charAt(k) - '0' + tens) % 10;
                    tens = (remain.charAt(k) - '0' + tens) / 10;
                    stringBuilder.append(ones);
                } else {
                    stringBuilder.append(remain.charAt(k));
                }
            }
        }

        return tens == 1? stringBuilder.append(1).reverse().toString() : stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Daily0110 daily0110 = new Daily0110();
//        String num = "112358";
//        String num = "199100199";
        String num = "101";
//        String num = "123563687241092";
        boolean isAdditiveNumber = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            isAdditiveNumber = daily0110.isAdditiveNumber(num);
//            isAdditiveNumber = daily0110.isAdditive(1, 1, "112358");
//            System.out.println(daily0110.stringAdd("123", "9946"));
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isAdditiveNumber);
    }
}
