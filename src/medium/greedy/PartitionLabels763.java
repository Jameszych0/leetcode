package medium.greedy;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        int[] index = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            // 记录了每个字母的最远下标
            index[chars[i] - 'a'] = i;
        int left = 0, right = 0; // 区间范围
        // 从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, index[chars[i] - 'a']);
            if (right == i) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
