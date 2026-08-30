class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find min and max indices
        for (int i = 0; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Put smaller index first
        int i = Math.min(minIndex, maxIndex);
        int j = Math.max(minIndex, maxIndex);

        // 1. Both from front
        int fromFront = j + 1;

        // 2. Both from back
        int fromBack = n - i;

        // 3. One from front, one from back
        int fromBoth = (i + 1) + (n - j);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }
}