package easy.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal14414594 {
    /*
     * 前序遍历
     */
    // 递归法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 迭代法
    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 栈是FILO，所以先存右节点再存左节点
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }

    /*
     * 中序遍历
     */
    // 递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 迭代法
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 通过循环，一直遍历到左子树的最后一个左节点的下一位，也就是null
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } 
            // 当cur到达null时，就到了这里
            else {
                // 将cur返回到左子树的最后一个左节点，并存到res中
                cur = stack.pop();
                res.add(cur.val);
                // 如果right为null，下一步cur就到了左节点的根节点
                cur = cur.right;
            }
        }
        return res;

    }

    /*
     * 后序遍历
     */
    // 递归法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 迭代法
    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            Collections.reverse(res);
        }

        return res;
    }

    /*
     * 层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // len代表这一层有多少个节点
            int len = queue.size();

            while (len > 0) {
                TreeNode node = queue.poll();
                // 把一层的节点放到临时表里
                temp.add(node.val);
                // 把这一层的子节点都放入到队列里
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                len--;
            }
            res.add(temp);
        }
        return res;
    }
}
