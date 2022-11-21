package medium.dp;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        // 表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];
        // 初始化，要到第一排或第一行只有一条路径
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }
}
