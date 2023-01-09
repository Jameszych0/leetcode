package medium.dp;

public class PalindromicSubstrings647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        // 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[len][len];
        // Arrays.fill(dp, false);初始化，因为布尔类型的默认值就是false，所以我们可以省略这个步骤
        /*
         * 我们根据递推公式来推遍历顺序dp[i + 1][j - 1] 应该是从下往上，从左往右
         */
        for (int i = len - 1; i >= 0; i--)
            for (int j = i; j < len; j++)
                if (s.charAt(i) == s.charAt(j))
                    // 递推公式
                    if (j - i <= 1) {
                        // 当i和j相等时或j-i=1时，可以直接判断为回文串
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1] == true) {
                        // 当j-i>1时，我们可以通过dp[i + 1][j - 1]的true false来判断是否满足回文条件
                        dp[i][j] = true;
                        res++;
                    }
        return res;
    }
}