#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool containsDuplicate(vector<int>& nums) {
        return unordered_set(nums.begin(), nums.end()).size() < nums.size();
    }
};
