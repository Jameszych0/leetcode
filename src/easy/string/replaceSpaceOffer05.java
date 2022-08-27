package easy.string;

public class replaceSpaceOffer05 {
    public String replaceSpace_way1(String s) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sBuilder.append("%20");
            else
                sBuilder.append(s.charAt(i));
        }
        return sBuilder.toString();
    }
}
