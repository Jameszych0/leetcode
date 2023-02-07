package medium.linklist;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList143 {
    // 双端队列
    public void reorderList02(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            deque.offer(cur);
            cur = cur.next;
        }
        cur = head;
        int count = 0;
        while (!deque.isEmpty()) {
            // 单双数插入
            if (count % 2 == 0)
                cur.next = deque.pollLast();
            else
                cur.next = deque.poll();
            cur = cur.next;
            count++;
        }
        cur.next = null;
    }

    // 双指针，反转链表
    public void reorderList03(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        right = reverseList(right);
        ListNode left = head;
        while (right != null) {
            ListNode curLeft = left.next;
            left.next = right;
            left = curLeft;
            ListNode curRight = right.next;
            right.next = left;
            right = curRight;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode pre = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
