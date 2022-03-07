package codingInterviewDay_2.day07;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Solution02 {
    /**
     * 剑指 Offer 27. 二叉树的镜像 - DFS
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = deque.remove();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
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
     * 剑指 Offer 27. 二叉树的镜像 - BFS, preorder
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree1(root.left);
        mirrorTree1(root.right);

        return root;
    }

    /**
     * 剑指 Offer 27. 二叉树的镜像 - BFS, postorder
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree2(root.left);
        TreeNode right = mirrorTree2(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
