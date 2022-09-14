package medium.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = queue.element().val;
            /* for (TreeNode temp : queue) {
                if (temp.val > max)
                    max = temp.val;
            }
            res.add(max); */
            while (len > 0) {
                TreeNode node = queue.poll();
                // 出来一个比一个
                if (node.val > max)
                    max = node.val;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                len--;
            }
            res.add(max);
        }

        return res;
    }
}
