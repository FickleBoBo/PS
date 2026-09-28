#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> b(n);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        b[i] = x - (i + 1);
    }

    sort(b.begin(), b.end());
    b.erase(unique(b.begin(), b.end()), b.end());

    int ans = 1, len = 1;
    for (int i = 1; i < b.size(); i++) {
        len = (b[i] == b[i - 1] + 1) ? len + 1 : 1;
        ans = max(ans, len);
    }

    cout << ans << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
