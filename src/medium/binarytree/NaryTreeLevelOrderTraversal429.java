package medium.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> val = new ArrayList<>();
            while (len > 0) {
            Node node = queue.poll();

            for (Node temp: node.children) {
                if (temp != null)
                    queue.offer(temp);
            }
            val.add(node.val);
            len--;
        } 
        res.add(val);
        }
        return res; 
    }
}
