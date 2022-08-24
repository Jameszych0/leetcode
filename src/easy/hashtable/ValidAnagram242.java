package easy.hashtable;

public class ValidAnagram242 {
    /*
     * 定义一个长度为26的数组，数组下标就是 字母-'a'
     * 先遍历s ++
     * 然后遍历t --
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char ch : s.toCharArray())
            record[ch - 'a']++;
        for (char ch : t.toCharArray())
            record[ch - 'a']--;
        for (int i = 0; i < 26; i++)
            if (record[i] != 0) 
                return false;
        return true;
    }
}
