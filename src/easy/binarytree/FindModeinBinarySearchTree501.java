package easy.binarytree;

import java.util.ArrayList;

public class FindModeinBinarySearchTree501 {
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return ;
        
        traversal(root.left);

        if (pre == null || root.val != pre.val)
            count = 1;
        else
            count++;
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        } else if (count == maxCount)
            resList.add(root.val);
        pre = root;

        traversal(root.right);
    }
}
