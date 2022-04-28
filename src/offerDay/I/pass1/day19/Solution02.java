package offerDay.I.pass1.day19;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution02 {
    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 - 一次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 - 存储路径、两次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                ancestor = path1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private void getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        TreeNode cur = root;
        path.add(cur);
        while (true) {
            if (cur.val > target.val) {
                cur = cur.left;
            } else if (cur.val < target.val) {
                cur = cur.right;
            } else {
                break;
            }
            path.add(cur);
        }
    }
}
