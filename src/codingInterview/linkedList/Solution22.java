package codingInterview.linkedList;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution22 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 顺序查找
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;
        for (int i = 0; i < n - k; i++) {
            cur = cur.next;
        }

        return cur;
    }

    private ListNode ans;
    private int cnt;

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        try {
            getKthFromEndRecur(head, k);
        } catch (Exception e) {
        }

        return ans;
    }

    /**
     * 递归方法
     *
     * @param head
     * @param k
     */
    private void getKthFromEndRecur(ListNode head, int k) throws Exception {
        if (head == null) {
            return;
        }

        getKthFromEndRecur(head.next, k);
        if (cnt + 1 == k) {
            ans = head;
            throw new Exception("已经找到结果啦~~");
        }
        cnt++;
    }

    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        int[] arr = {1,2,3,4,5};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(arr);
        singleLinkedList.traversal();

        /*
         * 测试 getKthFromEnd()
         */
        Solution22 solution22 = new Solution22();
        int k = 1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            singleLinkedList.head = solution22.getKthFromEnd1(singleLinkedList.head, k);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
    }
}
