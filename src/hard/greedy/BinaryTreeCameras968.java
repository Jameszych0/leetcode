package hard.greedy;

public class BinaryTreeCameras968 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if (minCame(root) == 0)
            res++;
        return res;
    }

    /**
     * 节点的状态值：
     * 0 表示无覆盖
     * 1 表示 有摄像头
     * 2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     * 从下往上
     */
    public int minCame(TreeNode root) {
        // 空节点默认初始化为2，避免在叶子节点上放摄像头
        if (root == null)
            return 2;
        // 后续遍历
        int left = minCame(root.left);
        int right = minCame(root.right);
        // 左右子节点都有覆盖，那父节点应该是无覆盖的状态，让父节点的父节点装摄像头
        if (left == 2 && right == 2) {
            return 0;
            // 当左右子节点有一个没有覆盖的时候，父节点就要装摄像头
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            // 这个情况是左右子节点要么有摄像头要么有覆盖，父节点就没有必要装摄像头了
            return 2;
        }
    }
}
