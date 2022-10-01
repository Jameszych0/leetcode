package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SumofLeftLeaves404 {
    // 层序遍历迭代法
    public int sumOfLeftLeaves01(TreeNode root) {
        int sum = 0;
        if (root == null)
            return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left); 
                    if (node.left.left == null && node.left.right == null)
                    // 判断是否是左叶子节点
                        sum += node.left.val;
                }
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            midValue = root.left.val;
        int sum = leftValue + rightValue + midValue;
        return sum;
    }
}
