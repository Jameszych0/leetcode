package medium.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int loop = 0;
        int mid = Math.min(rows, columns) / 2; // 转的圈数
        int i, j;
        int startX = 0, startY = 0;
        while (loop++ < mid) {
            for (j = startY; j < columns - loop; j++)
                res.add(matrix[startX][j]);
            for (i = startX; i < rows - loop; i++)
                res.add(matrix[i][j]);
            for (; j >= loop; j--)
                res.add(matrix[i][j]);
            for (; i >= loop; i--)
                res.add(matrix[i][j]);
            startX++;
            startY++;
        }
        // 中间的那一行好像都是从左往右的
        if (Math.min(rows, columns) % 2 == 1)
            if (columns > rows)
                for (j = mid; j < mid + columns - rows + 1; j++)
                    res.add(matrix[mid][j]);
            else 
                for (i = mid; i <mid + rows - columns + 1; i++)
                    res.add(matrix[i][mid]);
        return res;
    }
}
