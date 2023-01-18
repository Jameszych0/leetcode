package hard.greedy;

public class Candy135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        // Arrays.fill(candy, 1);
        // 右边跟左边比
        for (int i = 1; i < len; i++)
/*             if (ratings[i] > ratings[i - 1])
                candy[i] = candy[i - 1] + 1; */
            // 每个孩子至少一个糖果
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        // 左边跟右边比
        for (int i = len - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
        int sum = 0;
        for (int num : candy)
            sum += num;
        return sum;
    }
}