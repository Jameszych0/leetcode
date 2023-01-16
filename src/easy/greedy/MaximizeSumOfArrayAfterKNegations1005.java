package easy.greedy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 剪枝
        if (nums.length == 1)
            return k % 2 == 0 ? nums[0] : -nums[0];
        int index = 0, sum = 0;
        // 从小到大顺序排序
        Arrays.sort(nums);
        // 从最小的负数开始取正
        for (int i = 0; i < k; i++) {
            if (nums[index] < 0 && i < nums.length - 1) {
                nums[index] = -nums[index];
                // 判断什么时候到正数，没到的话index加1，到了的话就一直在最大的负数消耗k的次数
                if (nums[index] >= Math.abs(nums[index + 1]))
                    index++;
                continue;
            }
            // 最大的负数，消耗k的次数
            nums[index] = -nums[index];
        }
        // 求和
        for (int num : nums)
            sum += num;
        return sum;
    }
}
