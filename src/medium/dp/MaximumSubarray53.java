package medium.dp;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        // 包括下标i之前的最大连续子序列和为dp[i]
        int[] dp = new int[len];
        dp[0] = Math.max(nums[0], 0);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}