package medium.dp;

public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        // 长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[len1][len2];
    }
}
