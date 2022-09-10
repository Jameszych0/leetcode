package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree226 {
    /*
     * 递归前序
     */
    public TreeNode invertTree01(TreeNode root) {
        if (root == null)
            return null;
        swapChildren(root);
        invertTree01(root.left);
        invertTree01(root.right);
        // swapChildren(root); 后序遍历
        return root;
    }

    /*
     * BFS
     */
    public TreeNode invertTree02(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
            TreeNode node = queue.poll();
                swapChildren(node);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }

    /*
     * 迭代法
     */
    public TreeNode invertTree03(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swapChildren(node);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return root;
    }

    public void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
