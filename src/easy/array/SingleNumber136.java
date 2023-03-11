package easy.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    // 哈希
    public int singleNumber01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            int count = map.get(num);
            if (count == 1)
                return num;
        }
        return -1;
    }

    // 异或
    /*
     * 异或特点
     * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     * 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     */
    public int singleNumber02(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
