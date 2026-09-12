#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int cnt0 = count(v.begin() + 1, v.end() - 1, 0);

    if (v.front() == 0 && v.back() == 0) {
        cout << 0 << '\n';
        return;
    }
    if ((v.front() == 0 || v.back() == 0) && cnt0 >= 1) {
        cout << 1 << '\n';
        return;
    }
    if (cnt0 >= 2) {
        cout << 2 << '\n';
        return;
    }
    cout << -1 << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
