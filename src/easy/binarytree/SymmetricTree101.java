package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上往下判断左右两树对不对称
 */

public class SymmetricTree101 {
    /*
     * 递归法
     */
    public boolean isSymmetric01(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        if (left == null && right == null)
            return true;

        if (left.val != right.val)
            return false;

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);

        return outside && inside;
    }

    /*
     * 迭代法
     */
    public boolean isSymmetric02(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right != null)
                return false;
            if (left != null && right == null)
                return false;
            if (left == null && right == null)
                continue;
            if (left.val != right.val)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
