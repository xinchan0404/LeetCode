package leetCode.binaryTree.summary;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author xinchan
 * @version 1.0.1 2022-01-08
 */
public class Connect {
    /**
     * 完全二叉树：填充每个节点的下一个右侧节点指针 - 广度优先遍历、迭代
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.remove();
                if (i == 0) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = node;
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 完全二叉树：填充每个节点的下一个右侧节点指针 - 指针
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {

        return root;
    }

    /**
     * 完全二叉树：填充每个节点的下一个右侧节点指针 - 递归
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        connect2Recur(root);

        return root;
    }

    /**
     * 完全二叉树：填充每个节点的下一个右侧节点指针 - 递归
     *
     * @param root
     */
    private void connect2Recur(Node root) {
        if (root == null) {
            return;
        }

        connect2Recur(root.left);
        connect2Recur(root.right);

        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 connect()
         */
        Connect connect = new Connect();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
//            completeBinaryTree.root = connect.connect(completeBinaryTree.root);
//            completeBinaryTree.root = connect.connect1(completeBinaryTree.root);
            completeBinaryTree.root = connect.connect2(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        completeBinaryTree.root.preorder();
    }
}
