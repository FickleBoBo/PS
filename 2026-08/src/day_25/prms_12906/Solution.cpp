#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> v;
    for (int x : arr) {
        if (v.empty() || v.back() != x) v.push_back(x);
    }

    return v;
}
