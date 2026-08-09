class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // suffix[i] = total stones from i to n-1
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No stones left
        if (i >= n) {
            return 0;
        }

        // Can take all remaining stones
        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int maxStones = 0;

        // Try taking X stones, where 1 <= X <= 2*M
        for (int X = 1; X <= 2 * M; X++) {

            // Stones opponent can get after we take X
            int opponent = solve(i + X, Math.max(M, X));

            // Current player gets total remaining - opponent's best
            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}