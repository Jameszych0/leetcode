package medium.dp;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        // 因为递推公式是最小值，所以dp数组的初始化要全赋成最大数
        // dp[0]=0
        for (int i = 1; i <= amount; i++)
            dp[i] = max;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                if (dp[j - coins[i]] != max)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        return dp[amount] == max ? -1 : dp[amount];
    }
}
