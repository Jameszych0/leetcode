package medium.greedy;

public class JumpGameII45 {
    public int jump01(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        int count = 0;
        int curDistance = 0, nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, nums[i] + i);
            // if (i == curDistance) {
            //     if (curDistance != nums.length - 1) {
            //         count++;
            //         curDistance = nextDistance;
            //         if (curDistance >= nums.length - 1)
            //             return count;
            //     }
            // }
            // 当下一步的范围超过数组范围时，只要加一步就能到达
            if (nextDistance >= nums.length - 1)
                return ++count;
            // 当当前范围跟i相等时，需要增加下一步范围，步骤加一
            if (i == curDistance) {
                curDistance = nextDistance;
                count++;
            }
        }
        return count;
    }
}