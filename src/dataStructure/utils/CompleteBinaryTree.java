package dataStructure.utils;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-07
 */
public class CompleteBinaryTree {
    /*
     * instance field
     */
    public TreeNode root;
    public int[] array;
    public int length;

    /**
     * 构造器
     *
     * @param array
     */
    public CompleteBinaryTree(int[] array) {
        this.array = array;
        this.length = array.length;
    }

    /**
     * 根据顺序数组构造一颗 满二叉树
     *
     * @param index
     */
    public void fullBinaryTree(TreeNode root, int index) {
        if (array == null || length == 0) {
            return;
        }

        /*
         * 添加左子树节点
         */
        if (2 * index + 1 < length) {
            TreeNode left = new TreeNode(array[2 * index + 1]);
            root.left = left;
            fullBinaryTree(root.left, 2 * index + 1);
        }

        /*
         * 添加右子树节点
         */
        if (2 * index + 2 < length) {
            TreeNode right = new TreeNode(array[2 * index + 2]);
            root.right = right;
            fullBinaryTree(root.right, 2 * index + 2);
        }
    }

    public static void main(String[] args) {
        /*
         * 根据数组创建满二叉树
         */
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.fullBinaryTree(new TreeNode(1), 0);
    }
}