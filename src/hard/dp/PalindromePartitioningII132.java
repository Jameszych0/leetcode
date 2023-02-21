package hard.dp;

public class PalindromePartitioningII132 {
    public int minCut(String s) {
        int len = s.length();
        // 判断回文
        boolean[][] isPalindromic = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--)
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    if (j - i <= 1)
                        isPalindromic[i][j] = true;
                    else if (isPalindromic[i + 1][j - 1])
                        isPalindromic[i][j] = true;
            }
        // dp[i]：范围是[0, i]的回文子串，最少分割次数是dp[i]。
        int[] dp = new int[len];
        // 初始化
        for (int i = 0; i < len; i++)
            dp[i] = i;
        for (int i = 1; i < len; i++) {
            if (isPalindromic[0][i])
                dp[i] = 0;
            for (int j = 0; j < i; j++)
                if (isPalindromic[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
        }
        return dp[len - 1];
    }
}
