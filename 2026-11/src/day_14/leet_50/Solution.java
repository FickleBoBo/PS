package day_14.leet_50;

class Solution {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return binpow(x, n);
        } else {
            return 1 / binpow(x, -(long) n);
        }
    }

    static double binpow(double a, long n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) > 0) res *= a;
            a *= a;
            n >>= 1;
        }

        return res;
    }
}
