package medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res = queue.peek().val;
            while (len-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        
        return res;
    }
}
