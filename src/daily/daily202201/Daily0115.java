package daily.daily202201;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-15
 */
public class Daily0115 {
    /**
     * 1716. 计算力扣银行的钱
     * @param n
     * @return
     */
    public int totalMoney(int n) {
        return n >= 7? (28 * (n / 7) + 7 * (n / 7) * ((n / 7) - 1) / 2) + ((1 + (n % 7) + 2 * (n / 7)) * (n % 7) / 2) : (1 + (n % 7) + 2 * (n / 7)) * (n % 7) / 2;
    }


    /**
     * 1716. 计算力扣银行的钱
     * @param n
     * @return
     */
    public int totalMoney1(int n) {
        int tens = n / 7;
        int ones = n % 7;
        int balance = 0;
        if (n >= 7) {
            balance = 28 * tens + 7 * tens * (tens - 1) / 2;
        }
        balance += (1 + ones + 2 * tens) * ones / 2;
        return balance;
    }
}
