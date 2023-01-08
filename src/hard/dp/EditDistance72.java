package hard.dp;

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 初始化，根据递推公式只需要初始化dp[i][0] dp[0][j]
        for (int i = 1; i <= n1; i++)
            // dp[i][0]相当于把word1全部删掉
            dp[i][0] = i;
        for (int i = 1; i <= n2; i++)
            // dp[0][j]相当于把word2全部删掉
            dp[0][i] = i;
        for (int i = 1; i <= n1; i++)
            for (int j = 1; j <= n2; j++)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                    // 相等就不变
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    // 换dp[i - 1][j - 1] 增删dp[i][j - 1] dp[i - 1][j] 都是加1步骤
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        return dp[n1][n2];
    }
}