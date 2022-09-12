package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * n叉树
 * 思路和二叉树差不多
 */
public class MaximumDepthofNaryTree559 {
    public int maxDepth01(Node root) {
        int cnt = 0;
        if (root == null)
            return cnt;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                Node node = queue.poll();
                // 把所有子孩子都放进去
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null)
                        queue.offer(node.children.get(i));
                }
                len--;
            }
            cnt++;
        }
        return cnt;
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 0;

        for (Node node: root.children) {
            depth = Math.max(depth, maxDepth(node));
        }

        return depth + 1;
    }
}
