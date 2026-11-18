#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    double binpow(double a, long long n) {
        double res = 1;
        while (n > 0) {
            if (n & 1) res *= a;
            a *= a;
            n >>= 1;
        }

        return res;
    }

    double myPow(double x, int n) {
        if (n >= 0) {
            return binpow(x, n);
        } else {
            return 1 / binpow(x, -1LL * n);
        }
    }
};
