package medium.dp;

public class LongestPalindromicSubsequence516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // 字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i++) {
        // 初始化，当i = j时，字符串是回文，长度为1，这样递推公式：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]); 中dp[i][j]才不会被初始值覆盖。
            dp[i][i] = 1;
            // 遍历顺序从下往上，从左往右，注意这里i和j不能相等，否则i+1会大于j-1，而且我们已经初始化相等的情况
            for (int j = i + 1; j < len; j++)
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
        return dp[0][len - 1];
    }
}