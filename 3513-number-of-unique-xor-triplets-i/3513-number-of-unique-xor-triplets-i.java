class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;
        if (n == 2) return 2;

        // Smallest power of 2 greater than n
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }

        return ans;
    }
}