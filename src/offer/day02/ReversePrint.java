package offer.day02;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class ReversePrint {
    public static void main(String[] args) {
        /*
         * 创建单链表并插入节点
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(new ListNode(1));
        singleLinkedList.add(new ListNode(2));
        singleLinkedList.add(new ListNode(3));

        ListNode head = singleLinkedList.getHead();

        /*
         * 测试 reversePrint()
         */
        int[] res = reversePrint(head);

        System.out.println(Arrays.toString(res));
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 限制：
     * 1. 0 <= 链表长度 <= 10000
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode tmp = head;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            stack.push(tmp.getValue());
        }

        int[] res = new int[stack.size()];
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
