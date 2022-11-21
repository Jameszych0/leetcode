package easy.dp;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        // 到达第i台阶所花费的最少体力为dp[i]
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= len; i++) {
            // 递推公式
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }
}
