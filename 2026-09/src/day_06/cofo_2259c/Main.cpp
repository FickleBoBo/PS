#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    int s = 0, e = n - 1;
    while (s < n && a[s] == 0) s++;
    while (e >= 0 && a[e] == 0) e--;

    if (s <= e) {
        a[s] = a[e] = 1;
        for (int i = s + 1; i < e; i++) {
            if (a[i] == -1) a[i] = 0;
        }
    }

    for (int x : a) {
        cout << x << ' ';
    }
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
