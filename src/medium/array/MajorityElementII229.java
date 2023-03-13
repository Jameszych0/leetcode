package medium.array;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII229 {
    /*
     * 如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
     * 
     * 如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
     * 
     * 如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == cand1)
                count1++;
            else if (num == cand2)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(cand1);
        if (count2 > nums.length / 3)
            res.add(cand2);
        return res;
    }
}
