package easy.string;

public class ReverseString344 {
    public void reverseString(char[] s) {
        int Left = 0, Right = s.length - 1;
        while (Left < Right) {
            char temp = s[Left];
            s[Left] = s[Right];
            s[Right] = temp;
            Left++;
            Right--;
        }
    }
}
