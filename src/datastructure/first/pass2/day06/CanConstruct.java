package datastructure.first.pass2.day06;

/**
 * 383. 赎金信
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-16
 */
public class CanConstruct {
    public static void main(String[] args) {
        /*
         * 测试 canConstruct()
         */
        CanConstruct canConstruct = new CanConstruct();

        String ransomNote = "aa";
        String magazine = "aab";

        boolean canOrNot = canConstruct.canConstruct(ransomNote, magazine);

        System.out.println(canOrNot);
    }

    /**
     * 赎金信 -
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArray = new int[26];
        for (char c : magazine.toCharArray()) {
            magazineArray[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';
            if (magazineArray[index] > 0) {
                magazineArray[index]--;
            } else {
                return false;
            }
        }

        return true;
    }
}
