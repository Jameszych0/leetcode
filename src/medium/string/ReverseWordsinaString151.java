package medium.string;

public class ReverseWordsinaString151 {
    /*
     * 方法一
     * 1.从字符串最后开始遍历，当遇到第一个字母时，停下并存下这个值
     * 2.接着遍历，当遇到空格时，停下并存下这个值，这时就得到了一个单词的具体范围
     * 3.把单词存到一个新的数组，并在单词后面加一个空格
     * 4.重复以上操作，直到遍历到头
     * 5.最后返回一个新的字符串，注意范围，因为最后一个单词后面也有一个空格
     */
    public String reverseWords_way1(String s) {
        char[] initialArr = s.toCharArray();
        char[] newArr = new char[s.length()];
        int cnt = 0; // 新数组计数

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && initialArr[i] == ' ')
                i--;
            // 在单词的最后一位字母上
            int right = i;
            // 在单词前一位的空格上
            while (i >= 0 && initialArr[i] != ' ')
                i--;
            // 得到单词范围，覆给一个新的数组
            for (int j = i + 1; j <= right; j++) {
                newArr[cnt++] = initialArr[j];
                // 在单词后面加一个空格
                if (j == right)
                    newArr[cnt++] = ' ';
            }
        }
        // cnt == newArr.length + 1
        return new String(newArr, 0, cnt - 1);
        // length
    }

    /*
     * 方法二
     * 1.删除字符串中的空格
     * 2.把整个字符串反转
     * 3.再把每一个单词反转
     */
    public String reverseWords_way2(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        int start = 0, end = s.length() - 1;
        // 先把字符串前后的空格去除
        while (s.charAt(start) == ' ')
            start++;
        while (s.charAt(end) == ' ')
            end--;
        // 定义一个StringBuilder类型来存放单词
        StringBuilder sb = new StringBuilder();
        while (start >= end) {
            char ch = s.charAt(start);
            // 这个if语句删除空格并保存单词后的一个空格
            // 非常巧妙！！！
            // 第一个判断语句，插入单词，当遇到第一个空格时，第一个判断语句失效，但第二个判断语句执行，插入一个空格，之后两个判断语句失效，直到遍历到下一个字母
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(ch);
            start++;
        }
        return sb;
    }

    // 双指针反转字符串
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            // 这边StringBuilder的方法，正常交换，类型不匹配
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length(); // 这里不需要-1，之前写错了，在最后一个单词那会出问题，end就只能到字符串末尾，而后面反转字符串，end是-1的，无法完全反转

        // 为什么是start < n ?
        // 如果end > n了，后续操作就无法进行了，后面通过给start赋值来结束循环，很巧妙，注意记录
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ')
                end++;
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
