package hard.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords30 {
    /*
     * 滑动窗口+双HashMap优化
     * 关键在于只需要遍历0-wordLen-1为起始索引的子串,然后遍历边维护符合条件res
     * 具体逻辑可以看代码,核心就是动态维护根据cur的数目动态查找合法子串
     * 时间复杂度:O(N),空间复杂度:O(N)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 阴间案例
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        int len = s.length();
        // 单词总个数
        int wordNum = words.length;
        // 每个单词长度
        int wordLen = words[0].length();
        // words总长度
        int totalLen = wordNum * wordLen;
        if (totalLen > len)
            return res;
        // 存储words的单词和个数
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            // 找不到当前单词肯定没有
            if (s.indexOf(word) == -1)
                return res;
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        // 只需要遍历wordLen种起点:0~wordLen-1
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> hasWords = new HashMap<>();
            while (right + wordLen <= len) {
                String cur = s.substring(right, right + wordLen);
                right += wordLen;
                if (allWords.containsKey(cur)) {
                    // 1.allWords里有cur,说明是合法的,可以加入
                    hasWords.put(cur, hasWords.getOrDefault(cur, 0) + 1);
                    count++;
                    // 有一种特殊情况是有cur,但其数目超过了上限,需要一直舍弃左边的直至合法
                    while (hasWords.get(cur) > allWords.get(cur)) {
                        String del = s.substring(left, left + wordLen);
                        hasWords.put(del, hasWords.get(del) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // 2.allWords里有没cur,说明cur是不合法的,得将left指针移动到新的1right后面
                    left = right;
                    hasWords.clear();
                    count = 0;
                }
                // 每当count更新一次就判断是否符合预期
                if (count == wordNum)
                    res.add(left);
            }
        }
        return res;
    }
}
