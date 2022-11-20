package easy.dp;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        // dp数组含义：爬到第i层楼梯，有dp[i]种方法
        int[] dp = new int[n + 1];
        if (n <= 2)
            return n;
        // 初始化dp数组
        dp[1] = 1;
        dp[2] = 2;
        // 确定遍历顺序
        for (int i = 3; i <= n; i++) {
            // 确定递推公式 
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 回溯会超时
    int count = 0;

    public int climbStairs02(int n) {
        backtracking(n, 0);
        return count;
    }

    void backtracking(int n, int sum) {
        if (sum == n) {
            count++;
            return;
        }

        if (sum > n)
            return;

        for (int i = 1; i <= 2; i++) {
            sum += i;
            backtracking(n, sum);
            sum -= i;
        }
    }
}
