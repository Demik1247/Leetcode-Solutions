class Solution {
    public long sumAndMultiply(int n) {
        int rev = 0;
        int temp = n;

        // Reverse the number
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        // Build the number in original order, skipping zeros
        int x = 0;
        while (rev != 0) {
            int rem = rev % 10;
            if (rem != 0) {
                x = x * 10 + rem;
            }
            rev /= 10;
        }

        int sum = 0;
        temp = x;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return (long) sum * x;
    }
}