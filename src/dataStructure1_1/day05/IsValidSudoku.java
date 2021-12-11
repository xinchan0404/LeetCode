package dataStructure1_1.day05;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * 提示：
 * 1. board.length == 9
 * 2. board[i].length == 9
 * 3. board[i][j] 是一位数字（1-9）或者 '.'
 *
 * @author xinchan
 * @version 1.0.1 2021-11-29
 */
public class IsValidSudoku {
    public static void main(String[] args) {
//        char[][] board =
//            {{'5','3','.','.','7','.','.','.','.'}
//            ,{'6','.','.','1','9','5','.','.','.'}
//            ,{'.','9','8','.','.','.','.','6','.'}
//            ,{'8','.','.','.','6','.','.','.','3'}
//            ,{'4','.','.','8','.','3','.','.','1'}
//            ,{'7','.','.','.','2','.','.','.','6'}
//            ,{'.','6','.','.','.','.','2','8','.'}
//            ,{'.','.','.','4','1','9','.','.','5'}
//            ,{'.','.','.','.','8','.','.','7','9'}};

//        char[][] board =
//            {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board =
            { {'3', '5', '.', '.', '.', '.', '.', '.', '.'}
            , {'6', '3', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        boolean isValidSudoku;

        isValidSudoku = isValidSudoku1(board);

        System.out.println("是否为有效数独：" + isValidSudoku);
    }

    /**
     * 是否为有效数独 - HashSet、分别判断三个条件
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int column = board[0].length;

        /*
         * 判断每行是否有重复数字
         */
        if (!isValidRow(board, row, column)) {
            return false;
        }

        /*
         * 判断每列是否有重复数字
         */
        if (!isValidColumn(board, row, column)) {
            return false;
        }

        /*
         * 判断 3*3 方块内是否有重复数字
         */
        if (!isValid33(board)) {
            return false;
        }

        return true;
    }

    /**
     * 判断是否为有效数独 - 数组模拟 Set
     *
     * @return
     */
    public static boolean isValidSudoku1(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] subSudoku = new int[3][3][9];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    row[i][index]++;
                    column[j][index]++;
                    subSudoku[i / 3][j / 3][index]++;  // (0-8) / 3 = 0, 1, 2，横纵坐标正好划分为3份，即 9 个子数独
                    if (row[i][index] > 1 || column[j][index] > 1 || subSudoku[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 判断一行是否有重复数字
     *
     * @param board
     * @param row
     * @param column
     * @return
     */
    public static boolean isValidRow(char[][] board, int row, int column) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c)) {
                        return false;
                    }
                }
            }
            set.clear();
        }

        return true;
    }

    /**
     * 判断一列是否有重复数字
     *
     * @param board
     * @param row
     * @param column
     * @return
     */
    public static boolean isValidColumn(char[][] board, int row, int column) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (!set.add(c)) {
                        return false;
                    }
                }
            }
            set.clear();
        }

        return true;
    }

    /**
     * 判断 3*3 小方块内是否有重复数字
     *
     * @param board
     * @return
     */
    public static boolean isValid33(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 3 * (i / 3); j < 3 + 3 * (i / 3); j++) {
                for (int k = 3 * (i % 3); k < 3 + 3 * (i % 3); k++) {
                    char c = board[j][k];
                    if (c != '.') {
                        if (!set.add(c)) {
                            return false;
                        }
                    }
                }
            }
            set.clear();
        }

        return true;
    }
}
