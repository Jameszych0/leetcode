package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return res;
    }

    void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum > target)
            return;

        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            temp.add(candidates[i]);
            backtracking(candidates, target, i, sum);
            temp.removeLast();
            sum -= candidates[i];
        }
    }
}
