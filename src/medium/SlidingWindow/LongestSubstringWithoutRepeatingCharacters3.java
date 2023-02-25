package medium.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters3 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                // 如果left大就表示出现的字符不在滑动窗口中
                // 反之，我们就让left从map中出现的字符的后一位开始
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}