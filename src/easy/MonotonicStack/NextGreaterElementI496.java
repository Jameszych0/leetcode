package easy.MonotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElementI496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        // 默认初始化为-1
        Arrays.fill(res, -1);
        // 初始化map，nums1的值作为key，并按顺序赋下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums1[i], i);
        Deque<Integer> stack = new LinkedList<>();
        // 单调栈，从栈底到栈顶递减，存的是下标
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[stack.peek()] >= nums2[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    // 看看map里有没有nums2的值
                    if (map.containsKey(nums2[stack.peek()]))
                        res[map.get(nums2[stack.peek()])] = nums2[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
