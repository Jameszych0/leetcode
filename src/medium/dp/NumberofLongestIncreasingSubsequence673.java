package medium.dp;

public class NumberofLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int len = nums.length;
        int[] dp = new int[len]; // i之前（包括i）最长递增子序列的长度为dp[i]
        int[] count = new int[len]; // 以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]
        int maxCount = 0; // 最长递增序列的个数
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
        }
        for (int i = 1; i < len; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                maxCount = Math.max(maxCount, dp[i]);
            }
        // 题目求的是最长递增序列的个数，通过我们之前记录的maxCount求出res
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxCount)
                res += count[i];
        }
        return res;
    }
}