#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums) {
    return min(unordered_set(nums.begin(), nums.end()).size(), nums.size() / 2);
}
