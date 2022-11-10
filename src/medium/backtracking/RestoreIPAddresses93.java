package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 剪枝
        if (s.length() > 12)
            return res;
        backtracking(s, 0, 0);
        return res;
    }

    // 通过点来确定终止条件
    void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum > 3) {
            res.add(s);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                pointNum++;
                backtracking(s.substring(0, i + 1) + "." + s.substring(i + 2), i + 2, +pointNum);
                pointNum--;
            }
        }
    }

    // 根据题意来判断ip和不合法
    boolean isValid(String s, int start, int end) {
        if (start > end)
            return false;

        if (start != end && s.charAt(start) == 0)
            return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255)
                return false;
        }
        return true;
    }
}
