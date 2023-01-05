package easy.dp;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        int ns = s.length(), nt = t.length();
        // dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]
        int[][] dp = new int[ns + 1][nt + 1];
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                // 此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1]
                    dp[i][j] = dp[i][j - 1];
        }
        return dp[ns][nt] == ns ? true : false;
    }
}