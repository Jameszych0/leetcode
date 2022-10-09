package easy.binarytree;

public class MinimumAbsoluteDifferenceinBST530 {
    int res = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (pre != null)
            res = Math.min(root.val - pre.val, res);
        pre = root;
        traversal(root.right);
    }
}
