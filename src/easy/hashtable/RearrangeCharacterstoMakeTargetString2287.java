package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacterstoMakeTargetString2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tCount.containsKey(c))
                sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : tCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sCount.containsKey(c) ? sCount.get(c) : 0;
            ans = Math.min(ans, totalCount / count);
            if (ans == 0)
                return 0;
        }
        return ans;
    }
}
