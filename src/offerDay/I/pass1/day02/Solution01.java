package offerDay.I.pass1.day02;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * @author xinchan
 * @version 1.0.1 2022-￥06-23
 */
public class Solution01 {
    /**
     * 逆序数组原地填充
     */
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] ans = new int[n];
        cur = head;
        while (cur != null) {
            ans[--n] = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}


class Solution01_ {
    /**
     * 递归
     */
    private List<Integer> list;

    public int[] reversePrint(ListNode head) {
        list = new ArrayList<>();
        recur(head);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
}
