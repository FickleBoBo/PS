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

        vector<int> res;
        for (int i = len; i > 0; i--) {
            res.insert(res.end(), buckets[i].begin(), buckets[i].end());
        }
        res.resize(k);

        return res;
    }
};
