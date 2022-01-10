package daily.daily202111.daily1127;

import java.util.Arrays;

/**
 * 519. 随机翻转矩阵
 * 提示：
 * 1. 1 <= m, n <= 104
 * 2. 每次调用flip 时，矩阵中至少存在一个值为 0 的格子。
 * 3. 最多调用 1000 次 flip 和 reset 方法。
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class Daily1127 {
    public static void main(String[] args) {
        int[] loc = new int[2];
        // 创建对象
        RandomMatrix1 randomMatrix1 = new RandomMatrix1(3, 1);

        loc = randomMatrix1.flip();
        System.out.println(Arrays.toString(loc));
        loc = randomMatrix1.flip();
        System.out.println(Arrays.toString(loc));
        loc = randomMatrix1.flip();
        System.out.println(Arrays.toString(loc));
        randomMatrix1.reset();
        loc = randomMatrix1.flip();
        System.out.println(Arrays.toString(loc));
    }
}
