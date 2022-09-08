package easy.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal14414594 {
    /*
     *  前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    /*
     *  中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    /*
     *  后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

}
