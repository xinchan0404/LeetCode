package dailyTopic;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-15
 */
public class Daily1115 {

    public static void main(String[] args) {
        /*
         * 测试 bulbSwitch 方法
         */
        int n = 99999999;
        int res = bulbSwitch(n);
        System.out.println("res=" + res);
    }

    public static int bulbSwitch(int n) {
        int count = 0;

        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j+=i+1) {
                if (status[j] == 0) {
                    status[j] = 1;
                } else {
                    status[j] = 0;
                }
            }
        }

        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
