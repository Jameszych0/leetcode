package easy.array;

import java.util.Arrays;

public class MajorityElement169 {
    // 排序法
    public int majorityElement01(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 摩尔投票法
    // 诸王争霸赛开始【规则是目前投票数为0的话换候选人，自己人给自己人投票，敌方减票】
    // 摩尔投票法为啥成立？因为这里的众数是指大于总数数目的二分之一，举两个个极端例子
    // 121311【肯定有相邻的，其他的】或者111123【全部联合起来，敌方都抵消不了】
    public int majorityElement02(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == cand_num)
                count++;
            else if (count-- == 0) {
                cand_num = nums[i];
                count = 1;
            }
        return cand_num;
    }
}
