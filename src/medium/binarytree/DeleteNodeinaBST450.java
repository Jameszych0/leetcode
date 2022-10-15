package medium.binarytree;

public class DeleteNodeinaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 没有找到key
        if (root == null)
            return null;
        // 找到key
        if (root.val == key) {
            // 叶子节点
            if (root.left == null && root.right == null)
                return null;
            // 左空右不空
            else if (root.left == null && root.right != null)
                return root.right;
            // 左不空右空
            else if (root.left != null && root.right == null)
                return root.left;
            // 都不空
            else {
                // 将要删除的节点的左节点指向右叶子节点
                TreeNode node = root.right;
                while (node.left != null)
                    node = node.left;
                node.left = root.left;
                return root.right;
            }
        }
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        return root;
    }
}
