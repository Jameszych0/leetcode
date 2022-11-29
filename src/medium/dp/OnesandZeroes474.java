package medium.dp;

public class OnesandZeroes474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int oneNum, zeroNum;
        int[][] dp = new int[m + 1][n + 1];
        for (String str: strs) {
            oneNum = zeroNum = 0;
            for (char ch: str.toCharArray())
                if (ch == '0')
                    zeroNum++;
                else 
                    oneNum++;
                for (int i = m; i >= zeroNum; i--)
                    for (int j = n; j >= oneNum; j--)
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        }
        return dp[m][n];
    }
}
