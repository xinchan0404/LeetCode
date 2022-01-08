package leetCode.binaryTree.summary;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-08
 */
public class Node {
    /*
     * instance field
     */
    int val;
    Node left;
    Node right;
    Node next;

    /*
     * constructor
     */
    public Node(int val) {
        this.val = val;
    }

    /*
     * methods
     */
    public void preorder() {
        System.out.print(this + " ==> ");

        if (this.left != null) {
            this.left.preorder();
        }

        if (this.right != null) {
            this.right.preorder();
        }
    }

    @Override
    public String toString() {
        return "{" + "val=" + val + '}';
    }
}
