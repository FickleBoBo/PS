#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> cnt;
        for (char c : s) cnt[c]++;
        for (char c : t) cnt[c]--;

        for (auto [_, v] : cnt) {
            if (v) return false;
        }

        return true;
    }
};
