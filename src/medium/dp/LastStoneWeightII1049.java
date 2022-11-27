package medium.dp;

public class LastStoneWeightII1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num: stones)
            sum += num;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++)
            for (int j = target; j >= stones[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
        return sum - dp[target] * 2;
    }
}
