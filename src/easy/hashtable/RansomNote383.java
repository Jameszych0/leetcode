package easy.hashtable;

import java.util.HashMap;

/*
 * 字符串用foreach
 * char ch : str.toCharArray()
 */
public class RansomNote383 {
    // map
    public boolean canConstruct_way1(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Character temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i);
            if (hashMap.containsKey(temp))
                hashMap.put(temp, hashMap.get(temp) + 1);
            else
                hashMap.put(temp, 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i);
            if (hashMap.containsKey(temp) && (hashMap.get(temp) - 1) >= 0)
                hashMap.put(temp, hashMap.get(temp) - 1);
            else
                return false;
        }
        return true;
    }
    // 数组
    public boolean canConstruct_way2(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char ch : magazine.toCharArray())
            record[ch - 'a']++;
        for (char ch : ransomNote.toCharArray())
            record[ch - 'a']--;
        // 如果i小于0，就没有这个字母
        for (int i : record)
            if (i < 0)
                return false;
        return true;
    }
}
