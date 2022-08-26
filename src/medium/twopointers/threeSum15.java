package medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Arrays.asList()  	返回由指定数组支持的固定大小的列表。
 */
public class threeSum15 {
    // 双指针法
    // -3 -2 0 1 2 3
    // i L R
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 对数组进行排序 从小到大
        Arrays.sort(nums);
        // 对数组进行遍历
        for (int i = 0; i < nums.length; i++) {
            // 数组是从小到大排序的，如果第一个都大于0了，后面就不可能了。优化算法
            if (nums[i] > 0)
                return res;
            // 去重操作
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            // 定义双指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 去重逻辑如果放在这里的话 -1 0 0 0 1 1 1得不到结果
                // while (left < right && nums[left - 1] == nums[left])
                //     left++;
                // while (left < right && nums[right] == nums[right + 1])
                //     right--;

                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    // 将答案存入结果集
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 对双指针进行去重
                    // 判断left的下一个的nums值是否相等，如相等left++
                    // 判断right的上一个的nums值是否相等，如相等right--
                    while (left < right && nums[left - 1] == nums[left])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}
