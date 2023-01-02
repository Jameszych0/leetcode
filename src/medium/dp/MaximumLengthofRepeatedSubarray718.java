package medium.dp;

public class MaximumLengthofRepeatedSubarray718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        // 以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        int[][] dp = new int[n1 + 1][n2 + 1];
        int res = 0;
        for (int i = 1; i <= n1; i++)
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                if (res < dp[i][j])
                    res = dp[i][j];
            }
        return res;
    }
}
