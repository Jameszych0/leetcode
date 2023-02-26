package medium.SlidingWindow;

import java.util.Arrays;

public class PermutationinString567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 初始化
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2))
            return true;
        // 用大小为n的滑动窗口来维护cnt2，每次增一减一，就和cnt1比较
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2))
                return true;
        }
        return false;
    }
}
