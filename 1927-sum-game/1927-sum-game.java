class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;

        // Bob can win only if the difference can be exactly balanced.
        if ((qDiff * 9) % 2 != 0) {
            return true;
        }

        return diff != (qDiff * 9) / 2;
    }
}