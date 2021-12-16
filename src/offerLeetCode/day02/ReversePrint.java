package offerLeetCode.day02;

import offerLeetCode.utils.ListNode;
import offerLeetCode.utils.SingleLinkedList;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class ReversePrint {
    public static void main(String[] args) {
        /*
         * 创建单链表并插入节点
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int[] array = {1, 3, 2};
        singleLinkedList.createSingleLInkedList(array);
        singleLinkedList.traversal();
        ListNode head = singleLinkedList.head;

        /*
         * 测试 reversePrint()
         */
        ReversePrint reversePrint = new ReversePrint();

        int[] reverseArray = new int[0];

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            reverseArray = reversePrint.reversePrint(head);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.toString(reverseArray));
    }

    /**
     * 从尾到头打印链表 - 逆序 ==> 堆栈
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode tmp = head;

        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
