#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int maxSubArray(vector<int>& nums) {
        int cur = 0;
        int ans = INT_MIN;
        for (int x : nums) {
            cur = max(x, cur + x);
            ans = max(ans, cur);
        }

        return ans;
    }
};
