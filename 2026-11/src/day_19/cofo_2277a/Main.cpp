#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> cnt(1 + n);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    int left = 0;
    for (int i = 0; i <= n; i++) {
        if (cnt[i] == 0 || left + cnt[i] < k) {
            cout << i << '\n';
            return;
        }

        left += cnt[i] - k;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
