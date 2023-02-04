package medium.array;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = 0; // 控制循环次数
        int count = 1; // 填充数字
        int start = 0; // 每次循环的开始点(start, start)
        int i, j;
        while (loop++ < n /2) {
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++)
                res[start][j] = count++;
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++)
                res[i][j] = count++;
            // 模拟下侧从右到左
            for (; j >= loop; j--)
                res[i][j] = count++;
            // 模拟左侧从下到上
            for (; i >= loop; i--)
                res[i][j] = count++;
            start++;
        }
        // 单数给中间赋值
        if (n % 2 == 1)
            res[start][start] = count;
        return res;
    }
}
