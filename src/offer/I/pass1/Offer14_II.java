package offer.I.pass1;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * @author xinchan
 * @version 1.0.1 2022-05-02
 */
public class Offer14_II {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int tens = n / 3;
        int ones = n % 3;
        int p = 1000000007;
        if (ones == 1) {
            return (int) ((remainder(3, tens - 1, p) * 4) % p);
        } else if (ones == 2) {
            return (int) ((remainder(3, tens, p) * 2) % p);
        }
        return (int) remainder(3, tens, p) % p;
    }

    private long remainder(int x, int a, int p) {
        long ans = 1;
        for (int i = 0; i < a; i++) {
            ans = (ans * x) % p;
        }
        return ans;
    }
}

class Offer14_II_ {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int tens = n / 3;
        int ones = n % 3;
        int p = 1000000007;
        if (ones == 1) {
            return (int) ((quickPower(3, tens - 1, p) * 4) % p);
        } else if (ones == 2) {
            return (int) ((quickPower(3, tens, p) * 2) % p);
        }
        return (int) quickPower(3, tens, p) % p;
    }

    private long quickPower(int x, int n, int p) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 1) {
            return quickPower(x, n - 1, p) * x % p;
        }
        long tmp = quickPower(x, n / 2, p);
        return tmp * tmp % p;
    }

    private long quickPower(int x, int n, int p) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer14_II_ offer14_ii_ = new Offer14_II_();
        long l = offer14_ii_.quickPower(2, 10, 1023);
        System.out.println(l);
    }
}
