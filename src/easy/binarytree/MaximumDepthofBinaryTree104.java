package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree104 {
    /*
     * 迭代法
     */
    public int maxDepth01(TreeNode root) {
        int cnt = 0;
        if (root == null)
            return cnt;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
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

    /*
     * 递归法
     */
    public int maxDepth02(TreeNode root) {
        if (root == null)
            return 0;
        // 后序遍历求高度
        int leftheight = maxDepth02(root.left);
        int rightheight = maxDepth02(root.right);
        int depth = Math.max(leftheight, rightheight) + 1;
        return depth;
    }

}
