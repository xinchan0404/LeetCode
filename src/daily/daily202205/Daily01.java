package daily.daily202205;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-05-01
 */
public class Daily01 {
    private List<Integer> ans;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans = new ArrayList<>();
        inorder(root1);
        inorder(root2);
        Collections.sort(ans);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        ans.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }
}

class Daily01_ {
    private List<Integer> ans;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        this.ans = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        mergeSort(list1, list2);

        return ans;
    }

    private void mergeSort(List<Integer> list1, List<Integer> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0;
        int j = 0;
        while (i < size1 || j < size2) {
            if (i == size1) {
                ans.add(list2.get(j++));
                continue;
            } else if (j == size2) {
                ans.add(list1.get(i++));
                continue;
            }
            int l1 = list1.get(i);
            int l2 = list2.get(j);
            if (l1 < l2) {
                ans.add(l1);
                i++;
            } else {
                ans.add(l2);
                j++;
            }
        }
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }
}
