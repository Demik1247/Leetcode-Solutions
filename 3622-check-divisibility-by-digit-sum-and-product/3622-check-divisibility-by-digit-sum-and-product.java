
class Solution {
    public boolean checkDivisibility(int n) {
        int Sodd = sod(n);
        int Podd = pod(n);

        if (n % (Sodd + Podd) == 0)
            return true;

        return false;
    }

    private int sod(int n) {
        int sum = 0;

        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }

        return sum;
    }

    private int pod(int n) {
        int product = 1;

        while (n > 0) {
            int rem = n % 10;
            product *= rem;
            n /= 10;
        }

        return product;
    }
}