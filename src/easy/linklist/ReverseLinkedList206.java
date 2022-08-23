package easy.linklist;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next; //ListNode temp = cur;
            cur.next = pre;
            pre = cur;
            cur = temp; //cur = temp.next;
        }
        return pre;
    }
}
