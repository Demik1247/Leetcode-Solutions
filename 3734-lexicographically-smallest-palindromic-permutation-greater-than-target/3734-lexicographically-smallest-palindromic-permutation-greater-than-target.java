class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // A palindrome can have at most one odd frequency.
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // cnt now represents characters available in the LEFT half.
        for (int i = 0; i < 26; i++) {
            cnt[i] /= 2;
        }

        int half = n / 2;

        char[] ans = new char[n];

        /*
         * Try to make the left half equal to target's left half.
         */
        int pos = 0;

        while (pos < half) {

            int c = target.charAt(pos) - 'a';

            if (cnt[c] == 0) {
                break;
            }

            ans[pos] = target.charAt(pos);
            cnt[c]--;

            pos++;
        }

        /*
         * If the whole left half matches target,
         * construct the palindrome and check it.
         *
         * This is important for cases like:
         * s = "aac", target = "abb"
         * => "aca"
         */
        if (pos == half) {

            buildPalindrome(ans, half, middle);

            String candidate = new String(ans);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Backtrack.
         *
         * At each position, try the smallest character
         * strictly greater than target[pos].
         */
        while (true) {

            if (pos < half) {

                int targetChar = target.charAt(pos) - 'a';

                for (int c = targetChar + 1; c < 26; c++) {

                    if (cnt[c] > 0) {

                        ans[pos] = (char) ('a' + c);
                        cnt[c]--;

                        /*
                         * Fill everything after pos with the
                         * smallest possible characters.
                         */
                        int index = pos + 1;

                        for (int x = 0; x < 26; x++) {

                            while (cnt[x] > 0) {
                                ans[index++] = (char) ('a' + x);
                                cnt[x]--;
                            }
                        }

                        buildPalindrome(ans, half, middle);

                        return new String(ans);
                    }
                }
            }

            /*
             * Cannot increase this position.
             * Move backwards and restore its character.
             */
            if (pos == 0) {
                return "";
            }

            pos--;

            int old = target.charAt(pos) - 'a';
            cnt[old]++;
        }
    }

    private void buildPalindrome(char[] ans, int half, int middle) {

        // Middle character for odd length
        if (middle != -1) {
            ans[half] = (char) ('a' + middle);
        }

        // Mirror left half
        for (int i = 0; i < half; i++) {
            ans[ans.length - 1 - i] = ans[i];
        }
    }
}