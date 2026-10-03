#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        vector<bool> seen(1 + n);
        for (int x : nums) seen[x] = true;

        for (int i = 0; i <= n; i++) {
            if (!seen[i]) return i;
        }

        return -1;
    }
};
