package hard.dp;

public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];
        // 初始化
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false
        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= cp.length; j++)
            if (cp[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];
        // 填格子
        for (int i = 1; i <= cs.length; i++)
            for (int j = 1; j <= cp.length; j++)
                // 文本串和模式串末位字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                // 模式串末位是*
                else if (cp[j - 1] == '*')
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.')
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 2];
        return dp[cs.length][cp.length];
    }
}
