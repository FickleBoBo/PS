package day_14.leet_50;

class Solution {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return binPow(x, n);
        } else {
            return 1 / binPow(x, -(long) n);
        }
    }

    static double binPow(double a, long n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) > 0) res *= a;
            a *= a;
            n >>= 1;
        }
        return res;
    }
}
