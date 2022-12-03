package medium.dp;

public class PerfectSquares279 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = max;
        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                if (dp[j - i * i] != max)
                    // 求最小个数
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        return dp[n];
    }
}
