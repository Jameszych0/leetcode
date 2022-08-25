package easy.hashtable;

import java.util.HashSet;

public class HappyNumber202 {
    // 要仔细读题，本题说如果哦不是快乐数就进入无限循环，也就是说平方后的结果会重复出现，当重复出现时，就代表这不是快乐数了
    public boolean isHappy(int n) {
        // 当题目要快速判断数值的有无是 应用哈希表
        HashSet<Integer> hashset = new HashSet<>();
        // 判断条件
        while (n != 1 && !hashset.contains(n)) {
            hashset.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    // 求平方和
    public int getNextNumber(int n) {
        int res = 0, temp;
        while (n > 0) {
            temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }

}
