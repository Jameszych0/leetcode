package medium.greedy;

public class MonotoneIncreasingDigits738 {
    public int monotoneIncreasingDigits(int n) {
        // 将整数n转换为字符数组
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 初始化start，记录从什么位置转换成9
        int start = len;
        for (int i = len - 2; i >= 0; i--)
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        for (int i = start; i < len; i++)
            chars[i] = '9';
        return Integer.parseInt(String.valueOf(chars));
    }
}