package medium.greedy;

public class WiggleSubsequence376 {
    /*
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     * 子串 不能删除
     */
    // greedy
    public int wiggleMaxLength01(int[] nums) {
        int preDiff = 0, curDiff = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                preDiff = curDiff;
                res++;
            }
        }
        return res;
    }

    // dp
    public int wiggleMaxLength02(int [] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        // 0：谷 第i个数作为山谷的摆动子序列的最长长度，1：峰 第i个数作为山峰的摆动子序列的最长长度
        dp[0][0] = dp[0][1] = 1;
        // 因为这题要子序列，所以需要双重循环
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                else if (nums[i] < nums[j])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
