package dailyTopic;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-06
 */
public class Daily1106 {
    public static void main(String[] args) {
        /*
         * 测试 findRepeatNumber 方法
         */
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int result = findRepeatNumber(nums);
        System.out.println(result);

        /*
         * 测试 findNumberIn2DArray 方法
         */
        int[][] matrix = new int[2][0];
//        System.out.println(Arrays.deepToString(matrix));
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
        boolean found = findNumberIn2DArray(matrix, 1);
        System.out.println(found);
    }

    public static int findRepeatNumber(int[] nums) {
        int result = -1;

        label:
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    result = nums[i];
                    break label;
                }

                // 交换当前位置数据至它应该处于的位置
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        return result;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = 0;  // 表示当前起始行
        int cloumn = matrix[0].length - 1;  // 表示当前末尾列

        while(row <= matrix.length - 1 && cloumn >= 0) {
            if (matrix[row][cloumn] > target) {
                cloumn--;
            } else if (matrix[row][cloumn] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}
