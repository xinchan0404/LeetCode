package utils;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class TreeNode {
    /*
     * instance field
     */
    public int val;
    public TreeNode left;
    public TreeNode right;

    /*
     * constructor
     */
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /*
     * methods
     */

    /**
     * 前序遍历 - 根左右
     *
     */
    public void preorder() {
        /*
         * 根节点：相关操作
         */
        System.out.print(this + "==>");

        /*
         * 左子树：左子节点非空，递归左子树
         */
        if (this.left != null) {
            this.left.preorder();
        }

        /*
         * 右子树：右子节点非空，递归右子树
         */
        if (this.right != null) {
            this.right.preorder();
        }
    }

    /**
     * 中序遍历 - 左根右
     */
    public void inorder() {
        /*
         * 左子树：如果左子节点非空，遍历左子树
         */
        if (this.left != null) {
            this.left.inorder();
        }

        /*
         * 根节点：相关操作
         */
        System.out.print(this + "==>");

        /*
         * 右子树：如果右子节点非空，遍历右子树
         */
        if (this.right != null) {
            this.right.inorder();
        }
    }

    public void postorder() {
        /*
         * 左子树：如果左子节点非空，递归左子树
         */
        if (this.left != null) {
            this.left.postorder();
        }

        /*
         * 右子树：如果右子节点非空，递归右子节点
         */
        if (this.right != null) {
            this.right.postorder();
        }

        /*
         * 根节点：相关操作
         */
        System.out.print(this + "==>");
    }

    @Override
    public String toString() {
        return "{" + "val=" + val + '}';
    }
}
