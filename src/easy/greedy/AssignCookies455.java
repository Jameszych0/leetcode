package easy.greedy;

import java.util.Arrays;

public class AssignCookies455 {
    // 大胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--)
            if (index >= 0 && s[index] >= g[i]) {
                index--;
                res++;
            }
        return res;
    }
    /*
     * 小胃口
     * ……
     */
}