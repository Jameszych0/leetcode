package medium.dp;

public class CompletePack {
    static int[] weight = { 1, 3, 4 };
    static int[] value = { 15, 20, 30 };
    static int bagWeight = 4;

    public static void main(String[] args) {
        CompletePack01();
        System.out.println();
        CompletePack02();
    }

    private static void CompletePack01() {
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++)
            for (int j = weight[i]; j <= bagWeight; j++)
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);

        for (int maxValue : dp)
            System.out.print(maxValue + " ");
    }

    private static void CompletePack02() {
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i <= bagWeight; i++)
            for (int j = 0; j < weight.length; j++) {
                if (i < weight[j])
                    continue;
                dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
            }

        for (int maxValue : dp)
            System.out.print(maxValue + " ");
    }
}
