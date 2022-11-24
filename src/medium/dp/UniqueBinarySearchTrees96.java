package medium.dp;

public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        // 1到i为节点组成的二叉搜索树的个数为dp[i]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++) {
                // 二叉搜索树，如果以j为头节点，左子树就是j-1，右子树就是i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        return dp[n];
    }
}