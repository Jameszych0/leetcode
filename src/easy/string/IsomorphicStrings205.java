package easy.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    // 相当于找aabb……的词
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // map1，map2分别以s，t作为key t，s作为值
            // 相同的就没必要比了
            if (!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), t.charAt(i));
            if (!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), s.charAt(i));
            // 看字符相不相等
            if (map1.get(s.charAt(i)) != t.charAt(i) || map2.get(t.charAt(i)) != s.charAt(i))
                return false;
        }
        return true;
    }
}
