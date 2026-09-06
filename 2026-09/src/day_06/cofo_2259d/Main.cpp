#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    int cnt0 = count(a.begin(), a.end(), 0);

    if (cnt0 == 1) {
        cout << "NO\n";
        return;
    }

    bool find0 = false;
    string ans;
    cout << "YES\n";
    for (int x : a) {
        if (x > 0) {
            ans += 'A';
        } else if (!find0) {
            ans += 'B';
            find0 = true;
        } else {
            ans += 'C';
        }
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
