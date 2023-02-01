package medium.MonotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementII503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        // 在遍历中模拟循环数组
        for (int i = 1; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek() % len] < nums[i % len]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return res;
    }
}