package easy.linklist;

public class PalindromeLinkedList234 {
    // 使用数组
    public boolean isPalindrome01(ListNode head) {
        ListNode cur = head;
        int len = 0;
        // 求长度
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = cur.val;
            cur = cur.next;
        }
        for (int i = 0, j = len - 1; i < j; i++, j--)
            if (res[i] != res[j])
                return false;
        return true;
    }

    // 双指针
    public boolean isPalindrome02(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode pre = head, slow = head, fast = head;
        while (fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode cur1 = head;
        ListNode cur2 = reverseList(slow);
        while (cur1 != null) {
            if (cur1.val != cur2.val)
                return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    ListNode reverseList(ListNode head) {
        // 反转链表
        ListNode tmp = null;
        ListNode pre = null;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
