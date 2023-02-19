package easy.greedy;

public class SplitaStringinBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                count++;
            else
                count--;
            if (count == 0)
                res++;
        }
        return res;
    }
}
