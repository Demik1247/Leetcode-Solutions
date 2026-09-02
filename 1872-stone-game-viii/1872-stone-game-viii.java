class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        long sum = 0;

        for (int x : stones) {
            sum += x;
        }

        long best = sum;

        for (int i = n - 2; i >= 1; i--) {
            sum -= stones[i + 1];

            best = Math.max(sum - best, best);
        }

        return (int) best;
    }
}