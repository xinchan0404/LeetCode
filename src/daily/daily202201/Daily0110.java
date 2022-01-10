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
        if (n < 3) {
            return false;
        }

        int i = 1;
        int j = 2;
        while (true) {
            int a = Integer.parseInt(num.substring(0, i));
            int b = Integer.parseInt(num.substring(i, j));
            int sum = a + b;
            String sumS = String.valueOf(sum);
            if (sumS.equals(num.substring(j, j + sumS.length()))) {
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        Daily0110 daily0110 = new Daily0110();
        String num = "199100199";
        boolean isAdditiveNumber = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isAdditiveNumber = daily0110.isAdditiveNumber(num);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isAdditiveNumber);
    }
}
