package crackingInterview.pass1.ch02;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution02 {
    /**
     * 面试题 02.02. 返回倒数第 k 个节点 - 快慢指针
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return -1;
            }
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }


    private int cnt;
    private int ans = -1;
    /**
     * 面试题 02.02. 返回倒数第 k 个节点 - 递归
     * @param head
     * @param k
     * @return
     */
    public int kthToLast2(ListNode head, int k) {
        kthToLastRecur(head, k);

        return ans;
    }

    /**
     * 递归方法
     * @param head
     * @param k
     */
    private void kthToLastRecur(ListNode head, int k) {
        if (head == null) {
            return;
        }

        kthToLastRecur(head.next, k);
        if (cnt + 1 == k) {
            ans = head.val;
        }
        cnt++;
    }


    /**
     * 面试题 02.02. 返回倒数第 k 个节点 - 顺序查找
     * @param head
     * @param k
     * @return
     */
    public int kthToLast1(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (k <= 0 || k > n) {
            return -1;
        }

        cur = head;
        for (int i = 0; i < n - k; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
}
