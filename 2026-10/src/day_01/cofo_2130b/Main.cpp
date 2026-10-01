#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, s;
    cin >> n >> s;

    vector<int> cnt(3);
    while (n--) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    int sum = cnt[1] + cnt[2] * 2;
    if (sum > s || sum == s - 1) {
        while (cnt[0]--) cout << 0 << ' ';
        while (cnt[2]--) cout << 2 << ' ';
        while (cnt[1]--) cout << 1 << ' ';
        cout << '\n';
    } else {
        cout << -1 << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
