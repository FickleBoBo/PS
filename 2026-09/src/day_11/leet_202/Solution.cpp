#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int step(int x) {
        int sum = 0;
        while (x > 0) {
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }

        return sum;
    }

    bool isHappy(int n) {
        unordered_set<int> seen;
        while (!seen.contains(n)) {
            seen.insert(n);
            n = step(n);
        }

        return n == 1;
    }
};
