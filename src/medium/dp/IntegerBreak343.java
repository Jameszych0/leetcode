package medium.dp;

public class IntegerBreak343 {
    public int integerBreak(int n) {
        // 第i个数最大的结果就是dp[i]
        int[] dp = new int[n + 1];
        // 初始化
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= i/2; j++)
                // 递推公式
                // j * (i - j)就是拆成两个数，j * dp[i - j]拆成两个以上的数
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
        return dp[n];
    }
}