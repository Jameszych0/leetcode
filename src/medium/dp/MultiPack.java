package medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiPack {
    static int[] num = { 2, 3, 4 };
    static int bagWeight = 10;

    public static void main(String[] args) {
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        for (int i = 0; i < num.length; i++)
            while (num[i] > 1) {
                weight.add(weight.get(i));
                value.add(value.get(i));
                num[i]--;
            }
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weight.size(); i++)
            for (int j = bagWeight; j >= weight.get(i); j--)
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
        for (int i : dp)
            System.out.print(i + " ");
    }
}