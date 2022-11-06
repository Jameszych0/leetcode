package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return res;
    }

    void backtracking(int k, int n, int sum, int startIndex) {
        // 剪枝
        if (sum > n)
            return;
        // 终止条件
        if (path.size() == k)
            if (sum == n) {
                res.add(new ArrayList<>(path));
                return;
            }
        // 循环
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, sum, i + 1);
            // 回溯
            path.removeLast();
            sum -= i;
        }
    }
}
