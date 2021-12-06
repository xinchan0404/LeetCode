package dailyTopic.daily1126;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-26
 */
public class TreeNode {
    // instance field
    private int val;
    private TreeNode leftNode;
    private TreeNode rightNode;

    // constructor
    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    // methods
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 前序遍历二叉树
     */
    public void preOrder() {
        // 访问当前节点
        System.out.print(this + "--");
        // 如果当前节点的左子节点非空，递归前序遍历
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        // 如果当前节点的右子节点非空，递归前序遍历
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    @Override
    public String toString() {
        return "{" + "val=" + val + '}';
    }
}
