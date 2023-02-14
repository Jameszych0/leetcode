package medium.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BalanceaBinarySearchTree1382 {
    List<Integer> list = new LinkedList<>();
    public TreeNode balanceBST(TreeNode root) {
        traversal(root);
        return getTree(list, 0, list.size() - 1);
    }
    // 有序树转成有序数组
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
    // 有序数组转成有序树
    public TreeNode getTree(List<Integer> list, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = getTree(list, left, mid - 1);
        root.right = getTree(list, mid + 1, right);
        return root;
    }
}
