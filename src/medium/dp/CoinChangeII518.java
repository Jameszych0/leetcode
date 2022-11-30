package medium.dp;

public class CoinChangeII518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // dp数组初始化
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                // 算方法的时候就直接相加
                dp[j] += dp[j - coins[i]];
        return dp[amount];
    }
}
