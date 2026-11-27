#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> cnt;
        for (int x : nums) cnt[x]++;

        int len = nums.size();
        vector<vector<int>> buckets(1 + len);
        for (auto [x, c] : cnt) buckets[c].push_back(x);

        vector<int> ans;
        for (int i = len; i > 0; i--) {
            ans.insert(ans.end(), buckets[i].begin(), buckets[i].end());
        }
        ans.resize(k);

        return ans;
    }
};
