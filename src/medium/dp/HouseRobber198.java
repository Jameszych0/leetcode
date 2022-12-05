package medium.dp;

public class HouseRobber198 {
    public int rob(int[] nums) {
        int len = nums.length;
        // dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        return dp[len];
    }
}
