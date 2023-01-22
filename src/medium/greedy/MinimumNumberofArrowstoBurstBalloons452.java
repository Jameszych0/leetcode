package medium.greedy;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons452 {
    public int findMinArrowShots(int[][] points) {
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1; // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++)
            if (points[i - 1][1] < points[i][0])
                // 气球i和气球i-1不挨着，注意这里不是>=
                count++;
            else
                // 气球i和气球i-1挨着，更新重叠气球最小右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
        return count;
    }
}
