package easy.hashtable;

import java.util.HashSet;

public class IntersectionofTwoArrays349 {
    // 哈希用于查找某一个特定的值，set不重复
    public int[] intersection_way1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        for (int i : nums2) {
            if (hashSet.contains(i))
                res.add(i);
        }
        // set转数组，第二中方法没搞懂
        int[] temp = new int[res.size()];
        int i = 0;
        for (int num : res) {
            temp[i++] = num;
        }
        return temp;
        // return res.stream().mapToInt(x -> x).toArray();
    }
    //数组
    public int[] intersection_way2(int[] nums1, int[] nums2) {
        int[] nums = new int[1005];
        HashSet <Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            nums[i] = 1;
        }
        for (int i : nums2) {
            if (nums[i] == 1) {
                hashSet.add(i);
            }
        }
        return hashSet.stream().mapToInt(x -> x).toArray();
    }
}
