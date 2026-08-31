#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    int n = arr.size();
    int s = 0, e = n - 1;

    while (s < n && arr[s] != 2) s++;
    if (s == n) return {-1};

    while (arr[e] != 2) e--;

    return vector<int>(arr.begin() + s, arr.begin() + e + 1);
}
