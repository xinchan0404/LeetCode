package dataStructure.utils;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-07
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
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /*
     * methods
     */
    @Override
    public String toString() {
        return "{" + "val=" + val + "}";
    }

    /**
     * 前序遍历，根左右 - 递归
     */
    public void preOrder() {
        /*
         * 根：访问当前节点
         */
        System.out.print(this + " --> ");

        /*
         * 左：访问当前节点左子节点
         */
        if (this.left != null) {
            this.left.preOrder();
        }

        /*
         * 右：访问当前节点右子节点
         */
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
