package hard.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[stack.peek()] < heights[i])
                stack.push(i);
            else if (heights[stack.peek()] == heights[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        res = Math.max(res, w * h);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
