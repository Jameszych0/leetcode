package easy.dp;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        // 以下标i为结尾的连续递增的子序列长度为dp[i]
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i])
                dp[i] = dp[i - 1] + 1;
            if (res < dp[i])
                res = dp[i];
        }
        return res;
    }
}
