package medium.string;

public class ZigzagConversion6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int len = Math.min(numRows, s.length());
        String[] rows = new String[len];
        for (int i = 0; i < len; i++)
            rows[i] = "";
        // down loc控制
        boolean down = false;
        int loc = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[loc] = s.substring(i, i + 1);
            if (loc == 0 || loc == numRows - 1)
                down = !down;
            loc += down ? 1 : -1;
        }
        String res = "";
        for (String row : rows)
            res += row;
        return res;
    }
}
