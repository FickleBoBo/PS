#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<bool> vis(n);

    bool ok = true;

    priority_queue<pair<int, int>, vector<pair<int, int>>> pq;
    for (int i = 0; i < v.size(); i++) {
        pq.push({v[i], i});
    }

    while (!pq.empty()) {
        auto [pos, idx] = pq.top();
        pq.pop();
    }

    for (int i = 0; i < v.size(); i++) {
        if (v[i] == 0) {
            ans[i] = 1;
        }
    }

    if (ok) {
        vector<int> ans(n);
        for (int x : ans) {
            cout << x;
        }
        cout << '\n';
    } else {
        cout << -1;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
