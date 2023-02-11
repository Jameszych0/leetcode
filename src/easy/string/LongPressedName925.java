package easy.string;

public class LongPressedName925 {
    // 比较字符串，重复的略过，不一样的就返回false
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int n = name.length(), t = typed.length();
        while (i < n && j < t) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                // 如果第一个不一样就直接返回false
                if (j == 0)
                    return false;
                // 如果typed出现重复的，就一直移到不重复的
                while (j < t - 1 && typed.charAt(j) == typed.charAt(j - 1))
                    j++;
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                } else
                    return false;
            }
        }
        // 说明name没有匹配完
        if (i < n)
            return false;
        // 说明typed没有匹配完
        while (j < t) {
            if (typed.charAt(j - 1) == typed.charAt(j))
                j++;
            else
                return false;
        }
        return true;
    }
}
