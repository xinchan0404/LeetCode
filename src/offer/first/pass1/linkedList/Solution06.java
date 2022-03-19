package offer.first.pass1.linkedList;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution06 {
    /**
     * 剑指 Offer 06. 从尾到头打印链表 - 栈
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        int size = stack.size();
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = stack.pop();
        }
        return reversed;
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表 - 递归
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        reversePrintRecur(head, list);

        int size = list.size();
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = list.get(i);
        }

        return reversed;
    }

    /**
     * 递归
     * @param head
     */
    private void reversePrintRecur(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        reversePrintRecur(head.next, list);
        list.add(head.val);
    }
}
