package medium.linklist;

public class LinkedListCycleII142 {
    //双指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 快指针一次走两个节点，慢指针一次走一个节点
            // 如果是环形链表，当两个指针都进入到环形里，就相当于快指针在追慢指针，相对运动，一定会追到，而且是在一圈之内
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = head;
                ListNode index2 = fast;
                // 找入口，具体详见代码随想录
                // 画图，根据快慢指针相遇计算
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;        
    }
}
