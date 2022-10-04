package medium.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    // 左开右闭
    public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;
        int rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        int lenOfLeft = rootIndex - inBegin;

        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1, inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd, inorder, lenOfLeft + 1, inEnd);

        return root;
    }
}
