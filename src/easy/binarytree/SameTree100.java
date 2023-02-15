package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree100 {
    // 递归法
    public boolean isSameTree01(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    public boolean compare(TreeNode p, TreeNode q) {
        if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;
        else if (p == null && q == null)
            return true;
        else if (p.val != q.val)
            return false;
        boolean left = compare(p.left, q.left);
        boolean right = compare(p.right, q.right);
        return left && right;
    }

    // 递归法简化版
    public boolean isSameTree02(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;
        return isSameTree02(p.left, q.left) && isSameTree02(p.right, q.right);
    }

    // 迭代法
    public boolean isSameTree03(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while (!que.isEmpty()) {
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if (leftNode == null && rightNode == null)
                continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val)
                return false;
            que.offer(leftNode.left);
            que.offer(rightNode.left);
            que.offer(leftNode.right);
            que.offer(rightNode.right);
        }
        return true;
    }
}
