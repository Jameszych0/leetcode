package hard.array;

public class MedianofTwoSortedArrays4 {
    // 先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (m == 0)
            if (n % 2 == 0)
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            else
                return nums2[n / 2];
        if (n == 0)
            if (m % 2 == 0)
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            else
                return nums1[m / 2];
        int[] nums = new int[len];
        int i = 0, j = 0;
        int count = 0;
        while (count != len) {
            if (i == m) {
                while (j != n)
                    nums[count++] = nums2[j++];
                break;
            }
            if (j == n) {
                while (i != m)
                    nums[count++] = nums1[i++];
                break;
            }
            if (nums1[i] > nums2[j])
                nums[count++] = nums2[j++];
            else
                nums[count++] = nums1[i++];
        }
        if (len % 2 == 0)
            return (nums[len / 2 - 1] + nums[len / 2]) / 2;
        else
            return nums[len / 2];
    }
}
