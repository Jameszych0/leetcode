package medium.dp;

public class LongestPalindromicSubstring5 {
    // 动态规划
    public String longestPalindrome01(String s) {
        int len = s.length();
        int maxLen = 0;
        int left = 0, right = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--)
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    if (j - i <= 1)
                        dp[i][j] = true;
                    else if (dp[i + 1][j - 1] == true)
                if (dp[i][j] == true && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        // substring是左闭右开的
        return s.substring(left, right + 1);
    }
    // 中心扩散
    /* 
     * 在遍历中心点的时候，要注意中心点有两种情况。
     * 一个元素可以作为中心点，两个元素也可以作为中心点。
     */
    public String longestPalindrome02(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = res.length() > s1.length() ? res : s1;
            s2 = extend(s, i, i + 1);
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }        
        return s.substring(start + 1, end);
    }
}
