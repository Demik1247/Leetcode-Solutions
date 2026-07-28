class Solution {
    public String smallestPalindrome(String s) {
        int[] ar = new int[26];

        // Count frequency
        for (char c : s.toCharArray()) {
            ar[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String mid = "";

        // Build the left half in lexicographically smallest order
        for (int i = 0; i < 26; i++) {
            if (ar[i] % 2 == 1) {
                mid = String.valueOf((char) (i + 'a'));
            }

            for (int j = 0; j < ar[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        // Right half is reverse of left
        String right = left.reverse().toString();

        // Reverse again to restore left
        left.reverse();

        return left.toString() + mid + right;
    }
}