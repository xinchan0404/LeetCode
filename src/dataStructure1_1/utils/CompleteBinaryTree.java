package dataStructure1_1.utils;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-07
 */
public class CompleteBinaryTree {
    /*
     * instance field
     */
    public TreeNode root;
    public Integer[] array;
    public int length;

    /**
     * 构造器
     *
     * @param array
     */
    public CompleteBinaryTree(Integer[] array) {
        this.array = array;
        this.length = array.length;
    }

    /**
     * 根据顺序数组构造一颗 满二叉树
     *
     * @param index
     */
    public TreeNode fullBinaryTree(TreeNode root, int index) {
        if (array == null || length == 0) {
            return null;
        }
        if (root == null || index == 0) {
            root = new TreeNode(array[0]);
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

        return root;
    }

    /**
     * 根据顺序数组构造一颗 满二叉树 - 递归
     *
     * @param index
     * @return
     */
    public TreeNode fullBinaryTree(int index) {
        if (array == null || length == 0) {
            return null;
        }
        TreeNode node = null;
        if (array[index] != null) {
            node = new TreeNode(array[index]);

            if (2 * index + 1 < length) {
                node.left = fullBinaryTree(2 * index + 1);
            }

            if (2 * index + 2 < length) {
                node.right = fullBinaryTree(2 * index + 2);
            }
        }

        return node;
    }

    /*
     * Overloading
     */
    public TreeNode fullBinaryTree() {
        return fullBinaryTree(0);
    }

    /*
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
            System.out.println(" null");
        } else {
            System.out.println("树为空，无法遍历~~");
        }
    }

    public static void main(String[] args) {
        /*
         * 根据数组创建满二叉树
         */
        Integer[] array = {1, 2, 3, 4, null, null, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();
    }
}