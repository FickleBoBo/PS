#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int hammingWeight(int n) {
        return popcount((unsigned)n);
    }
};
