package hard.SlidingWindow;

public class MinimumWindowSubstring76 {
    /*
     * 滑动窗口的思想：
     * 用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，
     * 即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
     * 
     */
    /*
     * 步骤一
     * 不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
     * 
     * 步骤二
     * 不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，
     * 记录此时滑动窗口的长度，并保存最小值
     * 
     * 步骤三
     * 让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        // 窗口中的值
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;
        // l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, start = 0, size = Integer.MAX_VALUE, count = t.length();
        while (r < s.length()) {
            char c = s.charAt(r);
            // l到r包含了t中的值
            if (need[c] > 0)
                count--;
            need[c]--;
            // 包含了t中的所有值
            if (count == 0) {
                // 这时need中的值基本上都是小于零的，当其等于零时，说明遍历到了t中的值
                while (need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                // while循环结束后，窗口大小确定
                if (r - l + 1 < size) {// 不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;// 记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                // 让l再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。
                // 先把t中的一个值加1
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
