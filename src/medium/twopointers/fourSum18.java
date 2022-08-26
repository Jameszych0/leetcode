package medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class fourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        /*
         * 在三数之和的基础上再套一层for循环，注意去重
         * target = 3
         * -1 0 1 2 3 4
         *  i j L     R
         */
        for (int i = 0; i < nums.length; i++) {
            // 剪枝，优化算法
            if (nums[i] > 0 && nums[i] > target)
                return res;
            // 去重
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;

                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                        left++;
                    }

                }
            }
        }

        return res;
    }
}
