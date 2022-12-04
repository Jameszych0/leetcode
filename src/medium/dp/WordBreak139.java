package medium.dp;

import java.util.List;

import org.junit.Test;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i)))
                    dp[i] = true;
            }
        return dp[s.length()];
    }

    @Test
    public void test1() {
        boolean[] dp = new boolean[10];
        if (dp[1])
            System.out.println("未赋值是true");
        else
            System.out.println("未赋值是false");
    }
}
