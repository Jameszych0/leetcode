package medium.greedy;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
    public int maxProfit01(int[] prices, int fee) {
        int res = 0;
        int minPurchase = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPurchase > prices[i])
                minPurchase = prices[i]; // 相当于买入
            if (minPurchase <= prices[i] && minPurchase + fee >= prices[i])
                continue; // 不作操作，保持原有状态（买入，卖出，不买不卖）
            if (minPurchase + fee < prices[i]) {
                res += prices[i] - minPurchase - fee;
                minPurchase = prices[i] - fee;
                // 因为如果还在收获利润的区间里，表示并不是真正的卖出，而计算利润每次都要减去手续费，所以要让minPrice = prices[i] - fee;，这样在明天收获利润的时候，才不会多减一次手续费！
            }
        }
        return res;
    }

    public int maxProfit02(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int [len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] -fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
