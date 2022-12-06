package medium.dp;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    // 左闭右闭
    int robAction(int[] nums, int start, int end) {
        int len = end - start;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= len; i++)
            // dp数组与nums数组一个从1开始一个从0开始，所以nums要减1
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i - 1]);
        return dp[len];
    }
}
