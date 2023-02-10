package easy.hashtable;

import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters1002 {
    public List<String> commonChars(String[] words) {
        List<String> res = new LinkedList<>();
        if (words.length == 0)
            return res;
        int[] hash = new int[26]; // 统计所有字符串字符出现的最小频率
        // 初始化hash，用第一个字符串初始化
        for (int i = 0; i < words[0].length(); i++)
            hash[words[0].charAt(i) - 'a']++;
        for (int i = 1; i < words.length; i++) {
            // 求除第一个外的字符串字符出现的个数
            // 每次循环结束后重置
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < words[i].length(); j++)
                hashOtherStr[words[i].charAt(j) - 'a']++;
            // 求最小频率
            for (int j = 0; j < 26; j++)
                hash[j] = Math.min(hash[j], hashOtherStr[j]);
        }
        // 根据hash添加
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                char c = (char) (i + 'a');
                res.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return res;
    }
}
