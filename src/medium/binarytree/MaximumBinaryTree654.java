package medium.binarytree;

public class MaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construcTreeNode(nums, 0, nums.length);
    }

    public TreeNode construcTreeNode(int[] nums, int leftIndex, int rightIndex) {
        // 左开右闭，所以是1
        if (rightIndex - leftIndex < 1)
            return null;
        if (rightIndex - leftIndex == 1)
            return new TreeNode(nums[leftIndex]);
        
        int maxIndex = leftIndex;
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++)
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        
        TreeNode root = new TreeNode(maxVal);

        root.left = construcTreeNode(nums, leftIndex, maxIndex);
        root.right = construcTreeNode(nums, maxIndex + 1, rightIndex);

        return root;
    }
}
