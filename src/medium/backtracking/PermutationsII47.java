package medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, used);
        return res;
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;

            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
