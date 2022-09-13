package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree111 {
    public int minDepth(TreeNode root) {
        int cnt = 1;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left == null || node.right == null)
                    return cnt;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                len--;
            }
            cnt++;
        }
        return cnt;
    }
}
