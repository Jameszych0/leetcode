package medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII90 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean used[];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, 0, used);
        return res;
    }

    void backtracking(int[] nums, int startIndex, boolean[] used) {
        res.add(new ArrayList<>(path));

        if (startIndex == nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1, used);
            used[i] = false;
            path.removeLast();
        }
// 不用used版
/*         for (int i = startIndex; i < nums.length; i++) {
            跳过当前树层使用过的、相同的元素
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, used);
            path.removeLast();
        } */
    }
}