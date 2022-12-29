package medium.dp;

public class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 0买入 1卖出但没有冷冻期 2刚刚卖出有冷冻期 3卖出后的第二天有冷冻期
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3]));
    }
}
