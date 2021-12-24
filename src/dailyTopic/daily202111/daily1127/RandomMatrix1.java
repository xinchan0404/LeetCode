package dailyTopic.daily202111.daily1127;

import java.util.HashMap;

/**
 * 519. 随机翻转矩阵
 * 提示：
 * 1. 1 <= m, n <= 104
 * 2. 每次调用flip 时，矩阵中至少存在一个值为 0 的格子。
 * 3. 最多调用 1000 次 flip 和 reset 方法。
 * 思考：将二维数组降维，类似于一维数组的随机抽样，但本题初始化全部为 0，即不用从二维数组中取值，只需要给出随机抽样位置坐标。
 * 因此，不用考虑用 map 存储全部二维数组，可以使用 getOrDefault()
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class RandomMatrix1 {
    // instance field
    private int m;
    private int n;
    HashMap<Integer, Integer> map = new HashMap<>();
    private int len;

    // constructor
    public RandomMatrix1(int m, int n) {
        this.m = m;
        this.n = n;
        this.len = m * n;
    }

    public int[] flip() {
        int randomLoc = (int) (Math.random() * len);
        len--;

        int index = map.getOrDefault(randomLoc, randomLoc);
        map.put(randomLoc, map.getOrDefault(len, len));

        int[] loc = new int[2];  // 抽取随机位置坐标
        loc[0] = index / this.n;
        loc[1] = index % this.n;

        return loc;
    }

    public void reset() {
        len = this.m * this.n;
        map.clear();
    }
}
