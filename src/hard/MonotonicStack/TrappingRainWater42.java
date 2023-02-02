package hard.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater42 {
    // 单调栈
    public int trap01(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[stack.peek()] > height[i])
                stack.push(i);
            else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } // 上面两种情况其实可以合并，不pop后面相同高度就一个一个求，pop的话高度相同就一起求
            else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        // 求高，比较左边的高还是右边的高
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        // 求宽，注意要减1
                        int w = i - stack.peek() - 1;
                        res += w * h;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    // 双指针
    public int trap02(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int lheight = height[i];
            int rheight = height[i];
            // 求柱子左边柱子最大高度
            for (int l = i - 1; l >= 0; l--)
                if (lheight < height[l])
                    lheight = height[l];
            // 求柱子左边柱子最大高度
            for (int r = i + 1; r < len; r++)
                if (rheight < height[r])
                    rheight = height[r];
            int h = Math.min(lheight, rheight) - height[i];
            // 如果小于0就代表，这个柱子最高
            if (h > 0)
                res += h;
        }
        return res;
    }

    public int trap03(int[] height) {
        int res = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        // 记录每个柱子右边柱子最大高度
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        for (int i = 1; i < len - 1; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (h > 0)
                res += h;
        }
        return res;
    }
}
