package medium.greedy;

public class BestTimetoBuyandSellStockII122 {
    // greedy
    public int maxProfit01(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++)
            /*
             * 假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
             * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
             * 此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
             * 那么根据prices可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。
             */
            res += Math.max(prices[i] - prices[i - 1], 0);
        return res;
    }

    // dp
    public int maxProfit02(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 0卖出 1买入
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[ i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
