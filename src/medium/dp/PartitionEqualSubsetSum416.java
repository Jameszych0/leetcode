package medium.dp;

public class PartitionEqualSubsetSum416 {
    /*
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 可把问题分解成背包容量为11,能否把背包装满
     * weight == value
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        // 如果是奇数就不能平分
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++)
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        return dp[target] == target;
    }
}
