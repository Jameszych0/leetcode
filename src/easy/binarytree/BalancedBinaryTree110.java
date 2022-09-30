package easy.binarytree;

// 求高度后序遍历--向上返回结果
// 求深度前序遍历--直接向下遍历
public class BalancedBinaryTree110 {
    /*
     * 递归法
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;
        
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
