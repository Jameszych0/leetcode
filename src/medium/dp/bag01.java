package medium.dp;

public class bag01 {
    public static void main(String[] args) {
        int[] weight = { 1, 3, 4 };
        int[] value = { 15, 20, 30 };
        int bagsize = 4;
        testWeightBagProblem(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length;
        int[][] dp = new int[wlen + 1][bagsize + 1];

        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wlen = weight.length;
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < wlen; i++)
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }

        for (int i = 0; i <= bagWeight; i++)
            System.out.println(dp[i]);
    }
}
