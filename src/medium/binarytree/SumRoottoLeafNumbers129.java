package medium.binarytree;

import java.util.LinkedList;
import java.util.List;

public class SumRoottoLeafNumbers129 {
    int res = 0;
    List<Integer> path = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return res;
        // 初始化path
        path.add(root.val);
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root.left == null && root.right == null) {
            res += listToInt(path);
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            recur(root.left);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            recur(root.right);
            path.remove(path.size() - 1);
        }
        return;
    }
    // 求每一个从根节点到子节点的值
    public int listToInt(List<Integer> list) {
        int sum = 0;
        for (Integer num: list)
            sum = sum * 10 + num;
        return sum;
    }
}
