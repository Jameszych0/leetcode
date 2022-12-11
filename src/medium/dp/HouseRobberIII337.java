package medium.dp;

public class HouseRobberIII337 {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    // 使用后序遍历
    int[] robAction(TreeNode root) {
        // 偷与不偷
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
