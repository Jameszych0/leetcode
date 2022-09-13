package medium.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
// 注意只有两个节点的情况
        while (!deque.isEmpty()) {
            int len = deque.size();
            while (len > 0) {
                TreeNode node = deque.poll();
                if (node.left != null)
                    deque.offer(node.left);
                if (node.right != null)
                    deque.offer(node.right);
                // 当len为一时，就是树的最右边        
                if (len == 1)
                    res.add(node.val);
                len--;
            }
        }
        return res;
    }
}
