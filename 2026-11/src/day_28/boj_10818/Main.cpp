#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    auto [mnIt, mxIt] = minmax_element(v.begin(), v.end());
    cout << *mnIt << ' ' << *mxIt;
}
