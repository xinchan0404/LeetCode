package tencent.top50.pass1;

/**
 * 292. Nim 游戏
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution292 {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }
}
