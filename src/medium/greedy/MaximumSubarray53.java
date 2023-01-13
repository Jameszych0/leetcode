package medium.greedy;

public class MaximumSubarray53 {
    // greedy
    public int maxSubArray01(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            // 当sum小于0，就直接从下一位开始
            if (sum < 0)
                sum = 0;
        }
        return res;
    }
    // dp
    public int maxSubArray02(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = Math.max(nums[0], 0);
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
