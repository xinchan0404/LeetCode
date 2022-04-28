package offerDay.I.pass2.day20;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution01 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int preorderRootPos = preLeft;
        int inorderRootPos = map.get(preorder[preorderRootPos]);
        int subLeftTreeLen = inorderRootPos - inLeft;
        TreeNode root = new TreeNode(inorder[inorderRootPos]);

        root.left = dfs(preorder, inorder, preorderRootPos + 1, preorderRootPos + subLeftTreeLen,
                inLeft, inorderRootPos - 1);
        root.right = dfs(preorder, inorder, preorderRootPos + subLeftTreeLen + 1, preRight,
                inorderRootPos + 1, inRight);
        return root;
    }
}
