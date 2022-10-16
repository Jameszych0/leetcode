package medium.binarytree;

public class TrimaBinarySearchTree669 {
    // 用450题的方法没做出来
    public TreeNode trimBST01(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low || root.val > high) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left != null && root.right == null)
                return root.left;
            if (root.left == null && root.right != null)
                return root.right;
            if (root.left != null && root.right != null) {
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;
                cur.left = root.left;
                return root.right;
            }
        }
        root.left = trimBST01(root.left, low, high);
        root.right = trimBST01(root.right, low, high);

        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        // 当root的值小于最小值时，就返回root的右子树
        if (root.val < low)
            return trimBST(root.right, low, high);
        // 同理
        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
