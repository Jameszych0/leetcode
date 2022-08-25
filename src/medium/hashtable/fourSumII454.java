package medium.hashtable;

import java.util.HashMap;

public class fourSumII454 {
    // 分成两组12、34，分别算两组的和，最后相减，等于0，返回value
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int temp;
        int res = 0;
        // 1 2
        for (int i : nums1)
            for (int j : nums2) {
                temp = i + j;
                if (hashMap.containsKey(temp))
                    hashMap.put(temp, hashMap.get(temp) + 1);
                else
                    hashMap.put(temp, 1);
            }
        // 3 4
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (hashMap.containsKey(-temp)) 
                    res += hashMap.get(-temp);
            }
        }
        return res;
    }
}
