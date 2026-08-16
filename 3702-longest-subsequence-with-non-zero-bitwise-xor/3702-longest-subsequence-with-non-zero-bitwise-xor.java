class Solution {
    public int longestSubsequence(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        if (ans != 0) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return nums.length - 1;
            }
        }

        return 0;
    }
}