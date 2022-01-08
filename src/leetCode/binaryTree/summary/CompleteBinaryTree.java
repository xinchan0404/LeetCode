package leetCode.binaryTree.summary;

import utils.TreeNode;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-07
 */
public class CompleteBinaryTree {
    /*
     * instance field
     */
    public Node root;
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
    public Node fullBinaryTree(Node root, int index) {
        if (array == null || length == 0) {
            return null;
        }
        if (root == null || index == 0) {
            root = new Node(array[0]);
        }

        /*
         * 添加左子树节点
         */
        if (2 * index + 1 < length) {
            Node left = new Node(array[2 * index + 1]);
            root.left = left;
            fullBinaryTree(root.left, 2 * index + 1);
        }

        /*
         * 添加右子树节点
         */
        if (2 * index + 2 < length) {
            Node right = new Node(array[2 * index + 2]);
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
    public Node fullBinaryTree(int index) {
        if (array == null || length == 0) {
            return null;
        }
        Node node = null;
        if (array[index] != null) {
            node = new Node(array[index]);

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
    public Node fullBinaryTree() {
        return fullBinaryTree(0);
    }

    /*
     * 二叉树的前序遍历 - 根左右
     */
    public void preorder() {
        if (root != null) {
            root.preorder();
            System.out.println(" null");
        } else {
            System.out.println("树为空，无法遍历~~");
        }
    }

//    /**
//     * 二叉树的中序遍历 - 左根右
//     */
//    public void inorder() {
//        if (root != null) {
//            root.inorder();
//            System.out.println(" null");
//        } else {
//            System.out.println("二叉树为空，无法遍历~~");
//        }
//    }
//
//    /**
//     * 二叉树的后序遍历 - 左右根
//     */
//    public void postorder() {
//        if (root != null) {
//            root.postorder();
//            System.out.println(" null");
//        } else {
//            System.out.println("二叉树为空，无法遍历~~");
//        }
//    }

    public static void main(String[] args) {
        /*
         * 根据数组创建满二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();
    }
}