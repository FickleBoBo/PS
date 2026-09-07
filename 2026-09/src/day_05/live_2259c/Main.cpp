#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int s = -1, e = -1;
    for (int i = 0; i < v.size(); i++) {
        if (v[i] != 0) {
            s = i;
            break;
        }
    }
    for (int i = (int)v.size() - 1; i >= 0; i--) {
        if (v[i] != 0) {
            e = i;
            break;
        }
    }
    for (int i = s + 1; i < e; i++) {
        if (v[i] == -1) v[i] = 0;
    }

    if (s != -1) {
        v[s] = v[e] = 1;
    }

    for (int x : v) cout << x << ' ';
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
