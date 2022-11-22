package medium.dp;

public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;
        // 表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
        int[][] dp = new int[m][n];
        // 初始化，遇到1就停止
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++)
            dp[0][i] = 1;
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
            dp[i][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                // 遇到障碍，直接下一个循环
                if (obstacleGrid[i][j] != 0)
                    continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m - 1][n - 1];
    }
}
