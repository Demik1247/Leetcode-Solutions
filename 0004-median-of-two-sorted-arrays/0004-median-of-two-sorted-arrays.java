import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] sum = new int[m + n];

        for (int i = 0; i < m; i++) {
            sum[i] = nums1[i];
        }

        int t = m;

        for (int i = 0; i < n; i++) {
            sum[t++] = nums2[i];
        }

        Arrays.sort(sum);

        if ((m + n) % 2 == 0) {
            return (sum[(m + n) / 2 - 1] + sum[(m + n) / 2]) / 2.0;
        }

        return sum[(m + n) / 2];
    }
}