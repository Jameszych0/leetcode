package medium.linklist;

public class DesignLinkedList707 {
    int size;
    ListNode head;

    public DesignLinkedList707() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        // index是从零开始的，size是从一开始的，所以是>=
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        // 遍历到当前节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 判断index是否越界，小于0则等于0，大于size就不插入
        if (index < 0) index = 0;
        if (index > size) return ;
        ListNode cur = head;
        // 遍历到要插入节点的前一个节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        // 插入节点，注意先连接后面的节点，防止链表丢失
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return ;
        ListNode cur = head;
        // 遍历到要插入节点的前一个节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
