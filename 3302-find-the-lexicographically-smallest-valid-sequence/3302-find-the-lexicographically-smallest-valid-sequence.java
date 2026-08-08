class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suffix[i] = number of characters from the END of word2
        // that can be matched using word1[i...n-1]
        int[] suffix = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        boolean mismatchUsed = false;

        for (int i = 0; i < m; i++) {

            while (p < n) {

                // Characters match
                if (word1.charAt(p) == word2.charAt(i)) {
                    ans[i] = p;
                    p++;
                    break;
                }

                // Try using our one allowed mismatch
                if (!mismatchUsed) {

                    int remaining = m - i - 1;

                    // After choosing p as mismatch,
                    // we need to match word2[i+1 ... m-1]
                    // using word1[p+1 ... n-1].
                    if (suffix[p + 1] >= remaining) {

                        ans[i] = p;
                        p++;
                        mismatchUsed = true;
                        break;
                    }
                }

                p++;
            }

            // Couldn't find a valid index
            if (p == n && i < m - 1) {
                return new int[0];
            }
        }

        return ans;
    }
}