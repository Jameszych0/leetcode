package hard.dp;

public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        int ns = s.length(), nt = t.length();
        // 以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        int[][] dp = new int[ns + 1][nt + 1];
        // dp数组初始化，因为递推公式是由dp[i - 1][j - 1] + dp[i - 1][j]推出来的，所以要初始化dp[i][0]和dp[0][j]，根据题意当t为0时，dp[i][0]初始化为1……
        for (int i = 0; i <= ns; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= ns; i++)
            for (int j = 1; j <= nt; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    // 考虑s-1，不考虑s-1就是把s-1删除：我t往后移一格
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    // 把s-1删除
                    dp[i][j] = dp[i - 1][j];
            }
        return dp[ns][nt];
    }
}