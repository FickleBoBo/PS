#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> diff(n + 1);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        diff[min(n, (i + 1) * x)]++;
        diff[min(n, (i + 1) * (x + 1))]--;
    }

    for (int i = 1; i <= n; i++) {
        diff[i] += diff[i - 1];
    }

    int cnt = count(diff.begin(), diff.end() - 1, 0);
    cout << cnt << '\n';
    if (cnt) {
        for (int i = 0; i < n; i++) {
            if (diff[i] == 0) cout << i << ' ';
        }
        cout << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
