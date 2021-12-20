package dataStructure1_2.day10;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, null, 2, null, null, 3, null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 preorderTraversal()
         */
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> list = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list = preorderTraversal.preorderTraversal(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(list);
    }

    /**
     * 二叉树的前序遍历 - 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        preorder(root, list);

        return list;
    }

    /**
     * 前序遍历递归方法
     *
     * @param node
     * @param list
     */
    public void preorder(TreeNode node, List<Integer> list) {
        /*
         * 根节点：相关操作
         */
        list.add(node.val);

        /*
         * 左子树：左子节点非空，递归左子树
         */
        if (node.left != null) {
            preorder(node.left, list);
        }

        /*
         * 右子树：右子节点非空，递归右子树
         */
        if (node.right !=  null) {
            preorder(node.right, list);
        }
    }

    /**
     * 二叉树的前序遍历 - 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            while (left != null) {
                stack.push(left);

            }
        }

        return null;
    }
}
