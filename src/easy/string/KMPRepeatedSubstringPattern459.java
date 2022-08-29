package easy.string;

public class KMPRepeatedSubstringPattern459 {
    /*
     * 移动匹配
     * 如果s由重复的字符串构成，那两个s掐头去尾，中间一定有一个s
     */
    public boolean repeatedSubstringPattern_way1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);   
    }

    /*
     * kmp算法
     * 前缀和里最大的最长前后缀不包含的就是最小重复子串
     * 根据KMP算法求得最小重复子串的长度除以字符串的长度，如果等于0返回true
     * 注意最长前后缀等于0的情况
     */
    public boolean repeatedSubstringPattern_way2(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[j] = j;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }

        if (j != 0 && s.length() % (s.length() - j) == 0)
            return true;
        return false;
    }
}
