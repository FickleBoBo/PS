#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> countBits(int n) {
        vector<int> ans(n + 1);
        for (int i = 1; i <= n; i++) {
            int x = i;
            int cnt = 0;
            while (x) {
                if (x & 1) cnt++;
                x >>= 1;
            }
            ans[i] = cnt;
        }

        return ans;
    }
};
