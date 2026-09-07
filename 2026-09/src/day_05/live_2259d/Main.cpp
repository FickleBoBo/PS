#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int cnt0 = count(v.begin(), v.end(), 0);

    if (cnt0 != 1) {
        bool vis = false;
        cout << "YES\n";
        for (int x : v) {
            if (x > 0) {
                cout << 'A';
            } else {
                if (!vis) {
                    cout << 'B';
                    vis = true;
                } else {
                    cout << 'C';
                }
            }
        }
        cout << '\n';
    } else {
        cout << "NO\n";
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
