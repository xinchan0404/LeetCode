package leetCode.binaryTree.summary;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author xinchan
 * @version 1.0.1 2022-01-09
 */
public class Connect1 {
    /**
     * 普通二叉树下：填充每个节点的下一个右侧节点指针 - 广度优先遍历、迭代
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.remove();
                if (i < size - 1) {
                    node.next = deque.element();
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

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 connect()
         */
        Connect1 connect = new Connect1();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            completeBinaryTree.root = connect.connect(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        completeBinaryTree.root.preorder();
    }
}
