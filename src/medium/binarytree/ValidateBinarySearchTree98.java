package medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree98 {
    // 层序遍历解不出来
    public boolean isValidBST01(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.val < node.left.val)
                        return false;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.val > node.right.val)
                        return false;
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }

    // 递归
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (max != null && max.val >= root.val)
            return false;
        max = root;
        return isValidBST(root.right);

    }
}
