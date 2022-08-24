package medium.linklist;

public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //fast ---_--
        //slow --_---
        //相当于slow走了 链表总数size - n
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        //fast ---_--
        //fast要走n+1步，这样slow才能指向要删除节点的前一个节点
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //slow --_---
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
