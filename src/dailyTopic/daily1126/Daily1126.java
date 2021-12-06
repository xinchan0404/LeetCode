package dailyTopic.daily1126;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-26
 */
public class Daily1126 {
    public static void main(String[] args) {
//        Object[] treeArray = {1, 2, 3, 4, 5, 6, 7};
        Object[] treeArray = {1, 2, 3, null, null, null, 4, 5, null, null, null};
        int val = 2;

        BinaryTree binaryTree = new BinaryTree(treeArray);
        binaryTree.creatBinaryTreeByPreOrder();

        binaryTree.preOrder();
    }

    /**
     * 二叉搜索树中的搜索
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.getVal() == val) {
            return root;
        }

        if (root.getLeftNode() != null) {
            TreeNode res = searchBST(root.getLeftNode(), val);
            if (res != null) {
                return res;
            }
        }

        if (root.getRightNode() != null) {
            TreeNode res = searchBST(root.getRightNode(), val);
            if (res != null) {
                return res;
            }
        }

        return null;
    }

    /**
     * 前序遍历数组，创建树
     *
     * @param tree
     */
    public static void createTreeByPreOrder(int[] tree) {
        if (tree == null || tree.length == 0) {
            System.out.println("数组为空，无法遍历~~");
            return;
        }

        TreeNode cur = new TreeNode();
    }
}
