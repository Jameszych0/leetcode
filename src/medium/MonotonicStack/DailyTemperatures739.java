package medium.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        // 从栈底到栈顶，从大到小
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (temperatures[stack.peek()] >= temperatures[i])
                stack.push(i);
            else {
                // 如果没有入栈，默认为0
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}