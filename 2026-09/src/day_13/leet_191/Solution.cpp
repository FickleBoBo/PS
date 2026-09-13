#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int hammingWeight(int n) {
        int cnt = 0;
        while (n) {
            if (n & 1) cnt++;
            n >>= 1;
        }

        return cnt;
    }
};
