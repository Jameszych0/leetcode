package hard.dp;

public class BestTimetoBuyandSellStockIV188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        // 单数代表买入，双数代表卖出
        for (int i = 1; i < k * 2; i += 2)
            dp[0][i] = -prices[0];
        for (int i = 1; i < len; i++)
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i][j + 1] + prices[i]);
            }
        return dp[len - 1][2 * k];
    }
}
