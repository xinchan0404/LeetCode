package leetCode.binaryTree.summary;

import utils.TreeNode;

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
     * 填充每个节点的下一个右侧节点指针 - 广度优先遍历、迭代
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
        Connect connect = new Connect();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            completeBinaryTree.root = connect.connect(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
    }
}
