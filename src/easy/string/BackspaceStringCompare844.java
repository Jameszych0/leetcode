package easy.string;

public class BackspaceStringCompare844 {
    // 栈
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#')
                ssb.append(c);
            else if (ssb.length() > 0)
                ssb.deleteCharAt(ssb.length() - 1);
        }
        for (char c : t.toCharArray()) {
            if (c != '#')
                tsb.append(c);
            else if (tsb.length() > 0)
                tsb.deleteCharAt(tsb.length() - 1);
        }
        return ssb.toString().equals(tsb.toString());
    }
}
