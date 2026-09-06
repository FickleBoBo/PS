#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int binarySearch(vector<int>& v, int target) {
        int lo = 0;
        int hi = v.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (v[mid] < target) {
                lo = mid + 1;
            } else if (v[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    int search(vector<int>& nums, int target) {
        return binarySearch(nums, target);
    }
};
