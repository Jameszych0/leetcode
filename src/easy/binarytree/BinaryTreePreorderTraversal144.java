package easy.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer>res){
        if(root == null)
            return ;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
