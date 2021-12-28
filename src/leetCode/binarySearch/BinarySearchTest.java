package leetCode.binarySearch;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        /*
         * 测试 binarySearch()
         */
        BinarySearchTest binarySearchTest = new BinarySearchTest();
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos = binarySearchTest.binarySearch(nums, 0, nums.length - 1, 40);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pos);

        /*
         * 测试 binarySearch1() - 第一个 等于
         */
        int[] nums1 = {40, 40, 40, 40, 40, 40, 40, 80, 90, 100};
        int pos1 = -1;
        long startMs1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos1 = binarySearchTest.binarySearch1(nums1, 0, nums1.length - 1, 40);
        }
        long costMs1 = System.currentTimeMillis() - startMs1;
        System.out.println("耗时1：" + costMs1 + " ms");
        System.out.println(pos1);

        /*
         * 测试 binarySearch2() - 最后一个 等于
         */
        int[] nums2 = {40, 40, 40, 40, 40, 40, 40, 80, 90, 100};
        int pos2 = -1;
        long startMs2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos2 = binarySearchTest.binarySearch2(nums2, 0, nums1.length - 1, 40);
        }
        long costMs2 = System.currentTimeMillis() - startMs2;
        System.out.println("耗时2：" + costMs2 + " ms");
        System.out.println(pos2);

        /*
         * 测试 binarySearch3() - 最后一个 小于等于
         */
        int[] nums3 = {10, 20, 20, 40, 40, 40, 40, 80, 90, 100};
        int pos3 = -1;
        long startMs3 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos3 = binarySearchTest.binarySearch3(nums3, 0, nums1.length - 1, 35);
        }
        long costMs3 = System.currentTimeMillis() - startMs3;
        System.out.println("耗时3：" + costMs3 + " ms");
        System.out.println(pos3);

        /*
         * 测试 binarySearch4() - 第一个 大于等于
         */
        int[] nums4 = {10, 20, 20, 40, 40, 40, 40, 80, 90, 100};
        int pos4 = -1;
        long startMs4 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos4 = binarySearchTest.binarySearch4(nums4, 0, nums1.length - 1, 35);
        }
        long costMs4 = System.currentTimeMillis() - startMs4;
        System.out.println("耗时4：" + costMs4 + " ms");
        System.out.println(pos4);
    }

    /**
     * 基础版本，在 nums 中一定存在 target，返回 target 位置
     *
     * @param nums   搜索数组
     * @param left   初始左边界
     * @param right  初始右边界
     * @param target 目标值
     * @return target 位置
     */
    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;  // 如果 nums 中一定存在 target，不会到达此处
    }

    /**
     * 变体1，在 nums 中一定存在 target，但是 target 可能存在多个，需要返回第一个 target 的位置
     *
     * @param nums   搜索数组
     * @param left   初始左边界
     * @param right  初始右边界
     * @param target 目标值
     * @return 第一个 target 的位置
     */
    public int binarySearch1(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 变体2，在 nums 中一定存在 target，但是 target 可能存在多个，需要返回最后一个 target 的位置
     *
     * @param nums   搜索数组
     * @param left   初始左边界
     * @param right  初始右边界
     * @param target 目标值
     * @return 最后一个 target 位置
     */
    public int binarySearch2(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 变体3，在 nums 中不存在 target 或者存在多个 target，要返回最后一个 小于等于 target 的位置
     *
     * @param nums   搜索数组
     * @param left   初始左边界
     * @param right  初始右边界
     * @param target 目标值
     * @return 第一个 target 位置
     */
    public int binarySearch3(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return right;
    }

    /**
     * 变体4，在 nums 中不存在 target 或者存在多个 target，要返回第一个 大于等于 target 的位置
     *
     * @param nums   搜索数组
     * @param left   初始左边界
     * @param right  初始右边界
     * @param target 目标值
     * @return 第一个 target 位置
     */
    public int binarySearch4(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        return left;
    }
}
