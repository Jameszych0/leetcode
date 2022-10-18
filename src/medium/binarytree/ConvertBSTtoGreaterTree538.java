package medium.binarytree;

public class ConvertBSTtoGreaterTree538 {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return ;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}
