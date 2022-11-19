package easy.dp;

public class FibonacciNumber509 {
    public int fib01(int n) {
        if (n <= 1)
            return n;
        // dp数组:dp[i]的定义为：第i个数的斐波那契数值是dp[i]
        int[] dp = new int[n + 1];
        // 初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        // 递推，确定遍历顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public int fib02(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int fib03(int n) {
        if (n <= 1)
            return n;
        return fib03(n - 1) + fib03(n - 2);
    }
}
