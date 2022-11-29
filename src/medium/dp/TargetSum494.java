package medium.dp;

public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        if ((sum + target) % 2 != 0)
            return 0;
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++)
            for (int j = left; j >= nums[i]; j--)
                dp[j] += dp[j - nums[i]];
        return dp[left];
    }
}
