package medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * 本题candidate数组中有重复的元素，但结果不允许有重复的元素和相同的组合
 * 不重复的元素在前面几题中我们已经实现，这里就不再过多赘述
 * 相同的组合就要去重：树层去重，用一个used数组
 */
public class CombinationSumII40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length] ;
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, used);
        return res;
    }

    void backtracking(int[] candidates, int target, int startIndex, int sum, boolean[] used) {
        if (sum > target)
            return;

        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false)
                continue;
            temp.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, i + 1, sum + candidates[i], used);
            used[i] = false;
            temp.removeLast();
        }
    }
}
