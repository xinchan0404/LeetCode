package daily.daily202203;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Daily0701 {
    /**
     * 405. 数字转换为十六进制数 - 模拟进制转换
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long n = num;
        if (num < 0) {
            n = (1L << 32) + num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            long remainder = n % 16;
            if (remainder > 9) {
                stringBuilder.append((char) (remainder - 10 + 'a'));
            } else {
                stringBuilder.append(remainder);
            }
            n /= 16;
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 405. 数字转换为十六进制数 - 分组转换
     * @param num
     * @return
     */
    public String toHex1(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int group = num & 0b1111;
            if (group > 9) {
                stringBuilder.append((char) (group - 10 + 'a'));
            } else {
                stringBuilder.append(group);
            }
            num >>>= 4;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Daily0701 daily0701 = new Daily0701();
        int num = -1;
        String s = daily0701.toHex1(num);
        System.out.println(s);
    }
}
