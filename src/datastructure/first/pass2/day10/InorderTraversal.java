package datastructure.first.pass2.day10;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-21
 */
public class InorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.inorder();

        /*
         * 测试 inorderTraversal()
         */
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> list = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            list = inorderTraversal.inorderTraversal(completeBinaryTree.root);  // 1000000: 73 ms
            list = inorderTraversal.inorderTraversal1(completeBinaryTree.root);  // 1000000: 102 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(list);
    }

    /**
     * 二叉树的中序遍历 - 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        inorder(root, list);

        return list;
    }

    /**
     * 中序遍历递归方法
     *
     * @param node
     */
    public void inorder(TreeNode node, List<Integer> list) {
        /*
         * 左子树：如果左子节点非空，递归左子树
         */
        if (node.left != null) {
            inorder(node.left, list);
        }

        /*
         * 根节点：相关操作
         */
        list.add(node.val);

        /*
         * 右子树：如果右子节点非空，递归右子树
         */
        if (node.right != null) {
            inorder(node.right, list);
        }
    }

    /**
     * 二叉树的中序遍历 - 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
