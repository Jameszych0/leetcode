package medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes222 {
    /*
     * 普通二叉树性质
     */
    // 迭代法
    public int countNodes01(TreeNode root) {
        int cnt = 0;
        if (root == null)
            return cnt;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                cnt++;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

                len--;
            }
        }

        return cnt;
    }

    // 递归法
    public int countNodes02(TreeNode root) {
        if (root == null)
            return 0;

        int leftNum = countNodes02(root.left);
        int rightNum = countNodes02(root.right);
        int TreeNum = leftNum + rightNum + 1;
        
        return TreeNum;
    }

    /*
     * 完全二叉树性质
     */
    public int countNodes03(TreeNode root) {

        return 0;
    }
}
