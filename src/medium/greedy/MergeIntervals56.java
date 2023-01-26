package medium.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果边界不相交，就加入区间，并更新起始位置
            if (end < intervals[i][0]) {
                res.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            } else
                // 更新最大右边界
                end = Math.max(end, intervals[i][1]);
        }
        res.add(new int[] { start, end });
        return res.toArray(new int[res.size()][]);
    }
}