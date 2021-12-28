package leetCode.binarySearch.GuessNumber;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class GuessGame {
    /*
     * methods
     */
    public int guess(int num) {
        int pick = 6;
        return -Integer.compare(num, pick);
    }
}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
