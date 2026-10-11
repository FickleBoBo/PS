#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> v;
    for (int x : arr) {
        if (x % divisor == 0) v.push_back(x);
    }
    sort(v.begin(), v.end());

    if (v.empty()) return {-1};
    return v;
}
