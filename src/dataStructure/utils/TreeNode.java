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
}
