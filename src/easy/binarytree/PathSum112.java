package easy.binarytree;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == 0)
            return true;
        if (root.left == null && root.right == null && targetSum != 0)
            return false;

        if (root.left != null) {
            targetSum -= root.left.val;
            if (hasPathSum(root.left, targetSum))
                return true;
            targetSum += root.left.val;
        }
        if (root.right != null) {
            targetSum -= root.right.val;
            if (hasPathSum(root.right, targetSum))
                return true;
            targetSum += root.right.val;
        }
        return false;
    }
}
