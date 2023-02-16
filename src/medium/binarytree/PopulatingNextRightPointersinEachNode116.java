package medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode116 {
    // 迭代法
    public Node116 connect01(Node116 root) {
        if (root == null)
            return null;
        Queue<Node116> que = new LinkedList<>();
        // 双指针
        Node116 node = null, nodePre = null;
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    nodePre = que.poll();
                    node = nodePre;
                } else {
                    node = que.poll();
                    nodePre.next = node;
                    nodePre = nodePre.next;
                }
                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);
            }
        }
        return root;
    }

    // 递归法
    public Node116 connect02(Node116 root) {
        traversal(root);
        return root;
    }

    public void traversal(Node116 root) {
        if (root == null)
            return;
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null)
            if (root.next != null)
                root.right.next = root.next.left;
        traversal(root.left);
        traversal(root.right);
    }
}
