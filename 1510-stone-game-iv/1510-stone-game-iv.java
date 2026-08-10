class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[i] = true means the player whose turn it is
        // can force a win with i stones.

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                // If after removing j*j stones,
                // the opponent is in a losing position,
                // current player wins.
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}