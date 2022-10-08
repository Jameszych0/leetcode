package easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchinaBinarySearchTree700 {
    // 层序遍历
    public TreeNode searchBST01(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == val)
                        return node.left;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == val)
                        return node.right;
                }
            }
        }
        return null;
    }

    // 迭代法 二叉搜索树
    public TreeNode searchBST02(TreeNode root, int val) {
        if (root == null)
            return null;
        while (root != null)
            if (root.val < val)
                root = root.right;
            else if (root.val > val)
                root = root.left;
            else
                return root;
        return null;
    }

    // 递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        
        if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);

    }
}
