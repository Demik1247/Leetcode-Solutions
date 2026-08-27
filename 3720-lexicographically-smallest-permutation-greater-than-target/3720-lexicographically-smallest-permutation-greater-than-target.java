class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // We try to make the answer equal to target
        // up to some position, then make it larger.
        for (int i = n - 1; i >= 0; i--) {

            // Rebuild frequency for this position
            int[] count = freq.clone();

            boolean possible = true;

            // Match target[0 ... i-1]
            for (int j = 0; j < i; j++) {

                int x = target.charAt(j) - 'a';

                if (count[x] == 0) {
                    possible = false;
                    break;
                }

                count[x]--;
            }

            if (!possible) {
                continue;
            }

            // At position i, choose smallest character
            // strictly greater than target[i].
            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Equal prefix
                    ans.append(target, 0, i);

                    // Make this position greater
                    ans.append((char) ('a' + c));

                    count[c]--;

                    // Smallest suffix
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}