package medium.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd)
            return null;
        // 哈希表直接获得中序中根节点的位置
        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        // 根据根节点，分割左右
        // 注意是左开右闭
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right  = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
