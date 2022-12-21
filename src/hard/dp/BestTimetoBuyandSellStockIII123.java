package hard.dp;

public class BestTimetoBuyandSellStockIII123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 0：第一次买入 1:第一次卖出 2:第二次买入 3:第二次卖出
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        // 给一个初值，第一天买入卖出再买入
        dp[0][2] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
        }
        return dp[n - 1][3];
    }
}