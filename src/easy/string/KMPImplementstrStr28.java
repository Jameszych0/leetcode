package easy.string;

public class KMPImplementstrStr28 {

    public int strStr(String haystack, String needle) {
        // 题目条件，当模式串为空时，返回0
        if (needle.length() == 0)
            return 0;
        // 定义next数组
        int[] next = new int[needle.length()]; 
        // 求最长相等前后缀
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 文本串和模式串进行匹配，当出现不匹配是，模式串进行回退
            while (i > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            // 相等的话，模式串就向右前进一位
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            // 当j到达模式串末尾时，就代表匹配成功了
            if (j == needle.length())
                // 返回开始匹配的位置
                return i - needle.length() + 1;
        }
        return -1;
    }

    public void getNext(int[] next, String s) {
        int j = 0; // 前缀末尾，同时也是最长相等前后缀
        next[j] = j; // 初始化，next数组
        for (int i = 1; i < s.length(); i++) {
            // i是后缀末尾
            // 前后缀不相同的情况
            while (j > 0 && s.charAt(j) != s.charAt(i))
                // 回退到两数相等
                j = next[j - 1];
            // 前后缀相同的情况
            if (s.charAt(j) == s.charAt(i))
            // 最长相等前后缀+1
                j++;
            // 更新next数组
            next[i] = j;
        }
    }
}
