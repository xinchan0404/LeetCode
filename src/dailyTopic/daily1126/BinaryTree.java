package dailyTopic.daily1126;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-26
 */
public class BinaryTree {
    // instance field
    private TreeNode root;
    private Object[] treeArray;

    // constructor

    public BinaryTree(Object[] treeArray) {
        this.treeArray = treeArray;
    }

    /**
     * 前序遍历，创建二叉树
     *
     * @return
     */
    public void creatBinaryTreeByPreOrder() {
        if (treeArray == null || treeArray.length == 0) {
            System.out.println("数组为空，无法创建二叉树~~");
            return;
        }

        root = new TreeNode((int) treeArray[0]);

        creatByPreOrder(root, 0);
    }

    /**
     * 前序遍历，创建二叉树
     *
     * @param index
     */
    public void creatByPreOrder(TreeNode root, int index) {

        if (2 * index + 1 < treeArray.length && treeArray[2 * index + 1] != null) {
            TreeNode curLeftNode = new TreeNode((int) treeArray[2 * index + 1]);
            root.setLeftNode(curLeftNode);
            creatByPreOrder(root.getLeftNode(), 2 * index + 1);
        }

        if (2 * index + 2 < treeArray.length && treeArray[2 * index + 2] != null) {
            TreeNode curRightNode = new TreeNode((int) treeArray[2 * index + 2]);
            root.setRightNode(curRightNode);
            creatByPreOrder(root.getRightNode(), 2 * index + 2);
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历~~");
        }
    }
}
