package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree111 {
    public int minDepth01(TreeNode root) {
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

    public int minDepth02(TreeNode root) {
        if (root == null)
            return 0;
        int leftheight = minDepth02(root.left);
        int rightheight = minDepth02(root.right);

        if (root.left == null && root.right != null)
            return rightheight + 1;
        if (root.right == null && root.left != null)
            return leftheight + 1;
        return Math.min(leftheight, rightheight) + 1;
    }
}
