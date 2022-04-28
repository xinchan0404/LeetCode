package offer.I.pass1;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer07 {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return recur(0, n - 1, 0, n - 1);
    }
    
    private TreeNode recur(int leftPreorder, int rightPreorder, int leftInorder, int rightInorder) {
        if (leftPreorder > rightPreorder) {
            return null;
        }

        int rootVal = preorder[leftPreorder];  // 根节点值
        int rootIndex = map.get(rootVal);  //  基于中序遍历数组，获取根节点索引
        int len = rootIndex - leftInorder;  // 基于中序遍历数组，计算出左子树长度
        TreeNode root = new TreeNode(rootVal);
        root.left = recur(leftPreorder + 1, leftPreorder + len, leftInorder, rootIndex - 1);
        root.right = recur(leftPreorder + len + 1, rightPreorder, rootIndex + 1, rightInorder);

        return root;
    }
}
