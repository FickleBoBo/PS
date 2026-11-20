#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> cnt(1 + 100);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    int left = 0;
    for (int i = 0; i <= 100 + 1; i++) {
        if (cnt[i] >= k) {
            left += cnt[i] - k;
        } else {
            if (cnt[i] > 0 && left >= k - cnt[i]) {
                left -= k - cnt[i];
            } else {
                cout << i << '\n';
                return;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
