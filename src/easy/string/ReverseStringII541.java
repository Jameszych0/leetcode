package easy.string;

public class ReverseStringII541 {
    /*
     * 题目大意
     * 给定一个数值k，以2k的大小遍历字符串
     * 可以遍历到2k，反转前k个
     * 没遍历到2k但大于k,也反转前k个
     * 上面两种情况可以合成一种情况
     * 没遍历到k,就把遍历到的字符串反转
     */
    public String reverseStr(String s, int k) {
        // 转成数组
        char[] ch = s.toCharArray();
        // 以2k的大小遍历数组
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 这种情况可以全部反转
            if (i + k <= ch.length)
                reverse(ch, i, i + k - 1);
            // 部分反转
            else 
                reverse(ch, i, ch.length - 1);
        }

        return new String(ch);
    }
    // 构造一个反转函数
    public void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}
