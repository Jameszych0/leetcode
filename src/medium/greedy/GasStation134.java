package medium.greedy;

public class GasStation134 {
    public int canCompleteCircuit01(int[] gas, int[] cost) {
        int totalSum = 0, curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        // 首先要判断有没有剩下的油量
        return totalSum < 0 ? -1 : start;
    }
}