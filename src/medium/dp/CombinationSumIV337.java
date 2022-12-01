package medium.dp;

public class CombinationSumIV337 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 先背包后物品就是排列问题，物品会遍历很多次
        for (int i = 0; i < target; i++)
            for (int j = 0; j <= nums.length; j++) {
                if (i < nums[j])
                    continue;
                dp[i] += dp[i - nums[j]];
            }
        return dp[target];
    }
}
